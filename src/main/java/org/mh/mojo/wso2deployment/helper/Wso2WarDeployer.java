package org.mh.mojo.wso2deployment.helper;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.maven.plugin.logging.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.mh.mojo.wso2deployment.Serverconfig;
import org.wso2.carbon.webapp.mgt.WebappAdminPortType;
import org.wso2.carbon.webapp.mgt.xsd.WebappUploadData;

/**
 * Deploy test for WSO2 Application Server 5.2
 * 
 * @author mh
 */
public class Wso2WarDeployer {

    /** File read buffer size. */
    private static final int READ_BUFFER_SIZE = 4096;
    
    /** the admin web service proxy */
    public WebappAdminPortType adminSvc;

    protected Log log;
    
    /** construct proxy */
    public Wso2WarDeployer ( Serverconfig server, Log log ) {
	if ( server == null  ) {
	    log.error( "Server config is null." );
	    return;
	}
	this.log = log;
	log.info( "[WSO2 WAR Deployer] Init WSO2 SOAP client proxy (CXF 2.7.x type)..." );

	Properties properties = System.getProperties();
	properties.put( "org.apache.cxf.stax.allowInsecureParser", "1" );
	System.setProperties( properties );

	// ClientProxyFactoryBean
	JaxWsProxyFactoryBean clientFactory = new JaxWsProxyFactoryBean();

	/* serviceUrl = "https://localhost:9443" */
	String adminURL = server.getServerUrl() + "WebappAdmin.WebappAdminHttpsEndpoint/";
	log.info( "[WSO2 WAR Deployer] Endpoint URL: "+adminURL);

	clientFactory.setAddress( adminURL );
	clientFactory.setServiceClass( WebappAdminPortType.class );
	clientFactory.setUsername( server.getAdminUser() );
	clientFactory.setPassword( server.getAdminPassword() );

	log.info( "[WSO2 WAR Deployer] start proxy ..." );
	adminSvc = (WebappAdminPortType) clientFactory.create();

	Client clientProxy = ClientProxy.getClient( adminSvc );

	HTTPConduit conduit = (HTTPConduit) clientProxy.getConduit();
	HTTPClientPolicy httpClientPolicy = conduit.getClient();
	httpClientPolicy.setAllowChunking( false );

	String targetAddr = conduit.getTarget().getAddress().getValue();
	if ( targetAddr.toLowerCase().startsWith( "https:" ) ) {
	    TrustManager[] simpleTrustManager = new TrustManager[] { new X509TrustManager() {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		    return null;
		}

		public void checkClientTrusted( java.security.cert.X509Certificate[] certs, String authType ) {
		}

		public void checkServerTrusted( java.security.cert.X509Certificate[] certs, String authType ) {
		}
	    } };
	    TLSClientParameters tlsParams = new TLSClientParameters();
	    tlsParams.setTrustManagers( simpleTrustManager );
	    tlsParams.setDisableCNCheck( true ); // TODO enable CN check
	    conduit.setTlsClientParameters( tlsParams );
	}
    }

    /** prepare input data for war upload web service */
    private WebappUploadData getUploadData( File artifact, String name, String version ) throws Exception {
	InputStream fin = new FileInputStream( artifact );
	WebappUploadData data = new WebappUploadData();
	log.info( "[WSO2 WAR Deployer] Prepare uploadWebapp for "+name+" ...");

	// File file = new File( warFilename );
	// FileInputStream fin = new FileInputStream( deployable );
	final byte fileContent[] = readFully( fin );
	final int cnt = fileContent.length;
	log.info( "[WSO2 WAR Deployer] Read war with "+cnt+" bytes" );
	fin.close();

	org.wso2.carbon.webapp.mgt.xsd.ObjectFactory webappAdmObjFactory = new org.wso2.carbon.webapp.mgt.xsd.ObjectFactory();

	data.setFileName( webappAdmObjFactory.createWebappUploadDataFileName( name ) );
	data.setVersion( webappAdmObjFactory.createWebappUploadDataVersion( version ) );
	data.setDataHandler( webappAdmObjFactory.createWebappUploadDataDataHandler( fileContent ) );

	return data;
    }

    /** upload war via SOAP admin web service */
    public boolean upload( File artifact, String warFileName, String version ) {
	log.info( "[WSO2 WAR Deployer] Start WAR upload" );

	WebappUploadData warUpload;
	try {
	    warUpload = getUploadData( artifact, warFileName, version );
	} catch ( Exception e ) {
	    e.printStackTrace();
	    return false;
	}

	List<WebappUploadData> webappUploadDataList = new ArrayList<WebappUploadData>();
	webappUploadDataList.add( warUpload );

	log.info( "[WSO2 WAR Deployer] Invoking uploadWebapp for "+warFileName+" ...");
	Boolean uplResult = adminSvc.uploadWebapp( webappUploadDataList );

	log.info( "[WSO2 WAR Deployer] Upload "+warFileName+" result: "+uplResult );

	return uplResult;
    }

    /**
     * Read all data available in this input stream and return it as byte[].
     * Take care for memory on large files!
     * <p>
     * Imported from org.jcoderz.commons.util.IoUtil
     * </p>
     * 
     * @param is
     *            the input stream to read from (will not be closed).
     * @return a byte array containing all data read from the is.
     */
    private byte[] readFully( InputStream is ) throws IOException {
	final byte[] buffer = new byte[READ_BUFFER_SIZE];
	int read = 0;
	final ByteArrayOutputStream out = new ByteArrayOutputStream();

	while ( (read = is.read( buffer )) >= 0 ) {
	    out.write( buffer, 0, read );
	}

	return out.toByteArray();
    }

}
