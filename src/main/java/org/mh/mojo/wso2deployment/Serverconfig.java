package org.mh.mojo.wso2deployment;

/** configuration from POM goes here */
public class Serverconfig {

	private String serverId;
	private String serverUrl;
	private String adminUser;
	private String adminPassword;
	
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
	 * @return the serverUrl
	 */
	public String getServerUrl() {
		return serverUrl;
	}
	/**
	 * @param serverUrl the serverUrl to set
	 */
	public void setServerUrl( String serverUrl ) {
		this.serverUrl = serverUrl;
	}
	/**
	 * @return the adminUser
	 */
	public String getAdminUser() {
		return adminUser;
	}
	/**
	 * @param adminUser the adminUser to set
	 */
	public void setAdminUser( String adminUser ) {
		this.adminUser = adminUser;
	}
	/**
	 * @return the adminPassword
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	/**
	 * @param adminPassword the adminPassword to set
	 */
	public void setAdminPassword( String adminPassword ) {
		this.adminPassword = adminPassword;
	}

}
