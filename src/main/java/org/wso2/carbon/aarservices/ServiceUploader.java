package org.wso2.carbon.aarservices;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.8
 * 2013-12-23T10:35:02.346+01:00
 * Generated source version: 2.7.8
 * 
 */
@WebServiceClient(name = "ServiceUploader", 
                  wsdlLocation = "ServiceUploader.wsdl",
                  targetNamespace = "http://aarservices.carbon.wso2.org") 
public class ServiceUploader extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://aarservices.carbon.wso2.org", "ServiceUploader");
    public final static QName ServiceUploaderHttpsSoap12Endpoint = new QName("http://aarservices.carbon.wso2.org", "ServiceUploaderHttpsSoap12Endpoint");
    public final static QName ServiceUploaderHttpsSoap11Endpoint = new QName("http://aarservices.carbon.wso2.org", "ServiceUploaderHttpsSoap11Endpoint");
    public final static QName ServiceUploaderHttpsEndpoint = new QName("http://aarservices.carbon.wso2.org", "ServiceUploaderHttpsEndpoint");
    static {
        URL url = ServiceUploader.class.getResource("ServiceUploader.wsdl");
        if (url == null) {
            url = ServiceUploader.class.getClassLoader().getResource("ServiceUploader.wsdl");
        } 
        if (url == null) {
            java.util.logging.Logger.getLogger(ServiceUploader.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "ServiceUploader.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public ServiceUploader(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServiceUploader(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceUploader() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServiceUploader(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServiceUploader(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServiceUploader(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ServiceUploaderPortType
     */
    @WebEndpoint(name = "ServiceUploaderHttpsSoap12Endpoint")
    public ServiceUploaderPortType getServiceUploaderHttpsSoap12Endpoint() {
        return super.getPort(ServiceUploaderHttpsSoap12Endpoint, ServiceUploaderPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceUploaderPortType
     */
    @WebEndpoint(name = "ServiceUploaderHttpsSoap12Endpoint")
    public ServiceUploaderPortType getServiceUploaderHttpsSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(ServiceUploaderHttpsSoap12Endpoint, ServiceUploaderPortType.class, features);
    }
    /**
     *
     * @return
     *     returns ServiceUploaderPortType
     */
    @WebEndpoint(name = "ServiceUploaderHttpsSoap11Endpoint")
    public ServiceUploaderPortType getServiceUploaderHttpsSoap11Endpoint() {
        return super.getPort(ServiceUploaderHttpsSoap11Endpoint, ServiceUploaderPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceUploaderPortType
     */
    @WebEndpoint(name = "ServiceUploaderHttpsSoap11Endpoint")
    public ServiceUploaderPortType getServiceUploaderHttpsSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(ServiceUploaderHttpsSoap11Endpoint, ServiceUploaderPortType.class, features);
    }
    /**
     *
     * @return
     *     returns ServiceUploaderPortType
     */
    @WebEndpoint(name = "ServiceUploaderHttpsEndpoint")
    public ServiceUploaderPortType getServiceUploaderHttpsEndpoint() {
        return super.getPort(ServiceUploaderHttpsEndpoint, ServiceUploaderPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceUploaderPortType
     */
    @WebEndpoint(name = "ServiceUploaderHttpsEndpoint")
    public ServiceUploaderPortType getServiceUploaderHttpsEndpoint(WebServiceFeature... features) {
        return super.getPort(ServiceUploaderHttpsEndpoint, ServiceUploaderPortType.class, features);
    }

}
