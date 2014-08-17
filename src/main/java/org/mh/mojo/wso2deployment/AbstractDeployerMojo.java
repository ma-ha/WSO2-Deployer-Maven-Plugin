package org.mh.mojo.wso2deployment;

import java.util.List;

import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.metadata.ArtifactMetadataSource;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectBuilder;

/**
 * @author mh
 */
public abstract class AbstractDeployerMojo extends AbstractMojo {

    @Parameter( defaultValue = "${project}", readonly = true )
    protected MavenProject project;

    @Component
    protected ArtifactResolver artifactResolver;

    @Component
    protected ArtifactFactory artifactFactory;

    @Component
    protected ArtifactMetadataSource metadataSource;

    @Parameter( readonly = true, required = true, defaultValue = "${localRepository}" )
    protected ArtifactRepository localRepository;

    @Parameter( readonly = true, required = true, defaultValue = "${project.remoteArtifactRepositories}" )
    protected List<ArtifactRepository> remoteRepositories;

    @Component
    protected ArtifactResolver resolver;

    @Component
    protected MavenProjectBuilder projectBuilder;

}
