package org.mh.mojo.wso2deployment;

/** configuration from POM goes here */
public class Deployment {
	
	private String serverId;

	private String groupId;
	private String artifactId;
	private String artifactType;
	private String version;
	private String artifactClassifier;
	private boolean versionSubContext = true;
	
	
	public boolean isVersionSubContext() {
	    return versionSubContext;
	}
	public void setVersionSubContext( boolean versionSubContext ) {
	    this.versionSubContext = versionSubContext;
	}
	/**
	 * @return the serverId
	 */
	public String getServerId() {
		return serverId;
	}
	/**
	 * @param serverId the serverId to set
	 */
	public void setServerId( String serverId ) {
		this.serverId = serverId;
	}
	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId( String groupId ) {
		this.groupId = groupId;
	}
	/**
	 * @return the artifactId
	 */
	public String getArtifactId() {
		return artifactId;
	}
	/**
	 * @param artifactId the artifactId to set
	 */
	public void setArtifactId( String artifactId ) {
		this.artifactId = artifactId;
	}
	/**
	 * @return the artifactType
	 */
	public String getArtifactType() {
		return artifactType;
	}
	/**
	 * @param artifactType the artifactType to set
	 */
	public void setArtifactType( String artifactType ) {
		this.artifactType = artifactType;
	}

	/**
	 * @return the artifactClassifier
	 */
	public String getArtifactClassifier() {
		return artifactClassifier;
	}
	/**
	 * @param artifactClassifier the artifactClassifier to set
	 */
	public void setArtifactClassifier( String artifactClassifier ) {
		this.artifactClassifier = artifactClassifier;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion( String version ) {
		this.version = version;
	}
	
}
