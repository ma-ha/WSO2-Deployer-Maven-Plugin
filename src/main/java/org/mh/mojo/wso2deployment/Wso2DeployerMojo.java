package org.mh.mojo.wso2deployment;

import java.io.File;
import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.resolver.ArtifactNotFoundException;
import org.apache.maven.artifact.resolver.ArtifactResolutionException;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.mh.mojo.wso2deployment.helper.Wso2AarDeployer;
import org.mh.mojo.wso2deployment.helper.Wso2CarDeployer;
import org.mh.mojo.wso2deployment.helper.Wso2WarDeployer;

/**
 * Deploy Artifact(s) to WSO2 server(s).
 * 
 * @author MH
 */

@Mojo( name = "wso2", threadSafe = true, requiresDependencyResolution = ResolutionScope.TEST )
public class Wso2DeployerMojo extends AbstractDeployerMojo {

    @Parameter( readonly = true, defaultValue = "${plugin.artifacts}" )
    private List<Artifact> pluginDependencies;

    /** list of all server configs used within this deployment job */
    @Parameter
    private List<Serverconfig> environment;

    /** list of all deployment files */
    @Parameter
    private List<Deployment> deployments;

    /** Execute goal. */
    public void execute() throws MojoExecutionException, MojoFailureException {
	getLog().info( "[WSO2 Deployer Mojo] v0.4.0" );

	if ( environment == null ) {
	    getLog().error( "[WSO2 Deployer Mojo] environment is missing in pom plugin configuration" );
	    return;
	}
	if ( deployments == null ) {
	    getLog().error( "Wso2DeployerMojo: deployments is missing in pom plugin configuration" );
	    return;
	}

	for ( Serverconfig svr : environment ) {
	    getLog().info( "[WSO2 Deployer Mojo] Server ("+svr.getServerId()+") URL: " + svr.getServerUrl() );
	}
	for ( Deployment deploy : deployments ) {
	    getLog().info( "[WSO2 Deployer Mojo] ---------------------------------------------------" );
	    try {		
		getLog().info( "[WSO2 Deployer Mojo] Load artifact '"+deploy.getArtifactId()+"' from repository " );
		File artifact = loadArtifact( deploy );
		if ( artifact != null ) {
		    getLog().info( "[WSO2 Deployer Mojo] Starting deployment: " + artifact.getName() + " to " + deploy.getServerId() );
		    
		    if ( "war".equals(  deploy.getArtifactType().toLowerCase() ) ) {
			
			Wso2WarDeployer deployer = new Wso2WarDeployer( getServerconfById( deploy.getServerId() ), getLog() );
			getLog().info( "[WSO2 Deployer Mojo] Deploy with version subcontext: " + deploy.isVersionSubContext() );
			if ( deploy.isVersionSubContext() ) {
			    deployer.upload( artifact, deploy.getArtifactId()+".war", deploy.getVersion() );
			} else {
			    deployer.upload( artifact, deploy.getArtifactId()+".war", null );
			}
			
		    } else if ( "aar".equals(  deploy.getArtifactType().toLowerCase() ) ) {
			
			Wso2AarDeployer deployer = new Wso2AarDeployer(  getServerconfById( deploy.getServerId() ), getLog() );
			deployer.uploadAAR( artifact, deploy.getArtifactId()+".aar", "" );
			
		    } else  if ( "car".equals(  deploy.getArtifactType().toLowerCase() ) ) {
			
			Wso2CarDeployer deployer = new Wso2CarDeployer(  getServerconfById( deploy.getServerId() ), getLog() );
			deployer.uploadCAR( artifact, deploy.getArtifactId()+".aar", "jar" );
			
		    }
		    
		} else {
		    getLog().error( "[WSO2 Deployer Mojo] Error loading artifact "+deploy.getArtifactId() );
		}
	    } catch ( Exception e ) {
		getLog().error( e );
		getLog().error( "[WSO2 Deployer Mojo] Error deploying artifact "+deploy.getArtifactId() );
	    }
	}

    }
    
    private Serverconfig getServerconfById( String serverId ) {
	Serverconfig svrConf = null;
	for ( Serverconfig svr : environment ) {
	    if ( serverId.equals( svr.getServerId() ) ) {
		svrConf = svr;
	    }
	}
	return svrConf;
    }

    public File loadArtifact( Deployment deploable ) {
	File artifactFile = null;
	// set up atifact object
	Artifact artifact = artifactFactory.createArtifactWithClassifier( 
		deploable.getGroupId(), deploable.getArtifactId(), deploable.getVersion(), deploable.getArtifactType(),
		deploable.getArtifactClassifier() );
	try {
	    // resolve artifact
	    resolver.resolve( artifact, remoteRepositories, localRepository );
	    // load artifact
	    artifactFile = artifact.getFile();
	    
	} catch ( ArtifactResolutionException e ) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch ( ArtifactNotFoundException e ) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return artifactFile;
    }

}
