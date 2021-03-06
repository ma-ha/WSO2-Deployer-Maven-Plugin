package org.wso2.carbon.webapp.mgt;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.8
 * 2013-12-20T13:24:53.170+01:00
 * Generated source version: 2.7.8
 * 
 */
@WebService(targetNamespace = "http://mgt.webapp.carbon.wso2.org", name = "WebappAdminPortType")
@XmlSeeAlso({org.wso2.carbon.webapp.mgt.xsd.ObjectFactory.class, axis2.apache.org.xsd.ObjectFactory.class, org.wso2.carbon.core.persistence.metadata.xsd.ObjectFactory.class})
public interface WebappAdminPortType {

    @Oneway
    @Action(input = "urn:expireAllSessions")
    @RequestWrapper(localName = "expireAllSessions", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.ExpireAllSessions")
    @WebMethod(action = "urn:expireAllSessions")
    public void expireAllSessions(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName
    );

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:isDefaultVersionManagementEnabled", output = "urn:isDefaultVersionManagementEnabledResponse")
    @RequestWrapper(localName = "isDefaultVersionManagementEnabled", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.IsDefaultVersionManagementEnabled")
    @WebMethod(action = "urn:isDefaultVersionManagementEnabled")
    @ResponseWrapper(localName = "isDefaultVersionManagementEnabledResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.IsDefaultVersionManagementEnabledResponse")
    public java.lang.Boolean isDefaultVersionManagementEnabled();

    @Oneway
    @Action(input = "urn:deleteAllStartedWebapps")
    @RequestWrapper(localName = "deleteAllStartedWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DeleteAllStartedWebapps")
    @WebMethod(action = "urn:deleteAllStartedWebapps")
    public void deleteAllStartedWebapps();

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:uploadWebapp", output = "urn:uploadWebappResponse")
    @RequestWrapper(localName = "uploadWebapp", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.UploadWebapp")
    @WebMethod(action = "urn:uploadWebapp")
    @ResponseWrapper(localName = "uploadWebappResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.UploadWebappResponse")
    public java.lang.Boolean uploadWebapp(
        @WebParam(name = "webappUploadDataList", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<org.wso2.carbon.webapp.mgt.xsd.WebappUploadData> webappUploadDataList
    );

    @Oneway
    @Action(input = "urn:changeDefaultAppVersion", fault = {@FaultAction(className = WebappAdminArtifactMetadataException.class, value = "urn:changeDefaultAppVersionWebappAdminArtifactMetadataException")})
    @RequestWrapper(localName = "changeDefaultAppVersion", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.ChangeDefaultAppVersion")
    @WebMethod(action = "urn:changeDefaultAppVersion")
    public void changeDefaultAppVersion(
        @WebParam(name = "appGroupName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String appGroupName,
        @WebParam(name = "fileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String fileName
    ) throws WebappAdminArtifactMetadataException;

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:getPagedFaultyWebappsSummary", output = "urn:getPagedFaultyWebappsSummaryResponse")
    @RequestWrapper(localName = "getPagedFaultyWebappsSummary", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetPagedFaultyWebappsSummary")
    @WebMethod(action = "urn:getPagedFaultyWebappsSummary")
    @ResponseWrapper(localName = "getPagedFaultyWebappsSummaryResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetPagedFaultyWebappsSummaryResponse")
    public org.wso2.carbon.webapp.mgt.xsd.WebappsWrapper getPagedFaultyWebappsSummary(
        @WebParam(name = "webappSearchString", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappSearchString,
        @WebParam(name = "webappType", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappType,
        @WebParam(name = "pageNumber", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.Integer pageNumber
    );

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:isUnpackWARs", output = "urn:isUnpackWARsResponse")
    @RequestWrapper(localName = "isUnpackWARs", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.IsUnpackWARs")
    @WebMethod(action = "urn:isUnpackWARs")
    @ResponseWrapper(localName = "isUnpackWARsResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.IsUnpackWARsResponse")
    public java.lang.Boolean isUnpackWARs();

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:getActiveSessions", output = "urn:getActiveSessionsResponse")
    @RequestWrapper(localName = "getActiveSessions", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetActiveSessions")
    @WebMethod(action = "urn:getActiveSessions")
    @ResponseWrapper(localName = "getActiveSessionsResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetActiveSessionsResponse")
    public org.wso2.carbon.webapp.mgt.xsd.SessionsWrapper getActiveSessions(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName,
        @WebParam(name = "pageNumber", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.Integer pageNumber
    );

    @Oneway
    @Action(input = "urn:deleteAllStoppedWebapps")
    @RequestWrapper(localName = "deleteAllStoppedWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DeleteAllStoppedWebapps")
    @WebMethod(action = "urn:deleteAllStoppedWebapps")
    public void deleteAllStoppedWebapps();

    @Oneway
    @Action(input = "urn:reloadWebapps")
    @RequestWrapper(localName = "reloadWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.ReloadWebapps")
    @WebMethod(action = "urn:reloadWebapps")
    public void reloadWebapps(
        @WebParam(name = "webappFileNames", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> webappFileNames
    );

    @Oneway
    @Action(input = "urn:deleteStoppedWebapps")
    @RequestWrapper(localName = "deleteStoppedWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DeleteStoppedWebapps")
    @WebMethod(action = "urn:deleteStoppedWebapps")
    public void deleteStoppedWebapps(
        @WebParam(name = "webappFileNames", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> webappFileNames
    );

    @Oneway
    @Action(input = "urn:expireSessions")
    @RequestWrapper(localName = "expireSessions", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.ExpireSessions")
    @WebMethod(action = "urn:expireSessions")
    public void expireSessions(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName,
        @WebParam(name = "sessionIDs", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> sessionIDs
    );

    @Oneway
    @Action(input = "urn:stopAllWebapps")
    @RequestWrapper(localName = "stopAllWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.StopAllWebapps")
    @WebMethod(action = "urn:stopAllWebapps")
    public void stopAllWebapps();

    @Oneway
    @Action(input = "urn:stopWebapps")
    @RequestWrapper(localName = "stopWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.StopWebapps")
    @WebMethod(action = "urn:stopWebapps")
    public void stopWebapps(
        @WebParam(name = "webappFileNames", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> webappFileNames
    );

    @Oneway
    @Action(input = "urn:setBamConfiguration")
    @RequestWrapper(localName = "setBamConfiguration", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.SetBamConfiguration")
    @WebMethod(action = "urn:setBamConfiguration")
    public void setBamConfiguration(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName,
        @WebParam(name = "value", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String value
    );

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:getStartedWebapp", output = "urn:getStartedWebappResponse")
    @RequestWrapper(localName = "getStartedWebapp", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetStartedWebapp")
    @WebMethod(action = "urn:getStartedWebapp")
    @ResponseWrapper(localName = "getStartedWebappResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetStartedWebappResponse")
    public org.wso2.carbon.webapp.mgt.xsd.WebappMetadata getStartedWebapp(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName
    );

    @Oneway
    @Action(input = "urn:deleteStartedWebapps")
    @RequestWrapper(localName = "deleteStartedWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DeleteStartedWebapps")
    @WebMethod(action = "urn:deleteStartedWebapps")
    public void deleteStartedWebapps(
        @WebParam(name = "webappFileNames", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> webappFileNames
    );

    @Oneway
    @Action(input = "urn:deleteAllWebApps")
    @RequestWrapper(localName = "deleteAllWebApps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DeleteAllWebApps")
    @WebMethod(action = "urn:deleteAllWebApps")
    public void deleteAllWebApps(
        @WebParam(name = "webappFileNames", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> webappFileNames
    );

    @Oneway
    @Action(input = "urn:deleteFaultyWebapps")
    @RequestWrapper(localName = "deleteFaultyWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DeleteFaultyWebapps")
    @WebMethod(action = "urn:deleteFaultyWebapps")
    public void deleteFaultyWebapps(
        @WebParam(name = "webappFileNames", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> webappFileNames
    );

    @Oneway
    @Action(input = "urn:startWebapps")
    @RequestWrapper(localName = "startWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.StartWebapps")
    @WebMethod(action = "urn:startWebapps")
    public void startWebapps(
        @WebParam(name = "webappFileNames", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> webappFileNames
    );

    @Oneway
    @Action(input = "urn:deleteAllFaultyWebapps")
    @RequestWrapper(localName = "deleteAllFaultyWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DeleteAllFaultyWebapps")
    @WebMethod(action = "urn:deleteAllFaultyWebapps")
    public void deleteAllFaultyWebapps();

    @Oneway
    @Action(input = "urn:expireSessionsInAllWebapps")
    @RequestWrapper(localName = "expireSessionsInAllWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.ExpireSessionsInAllWebapps")
    @WebMethod(action = "urn:expireSessionsInAllWebapps")
    public void expireSessionsInAllWebapps();

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:getBamConfiguration", output = "urn:getBamConfigurationResponse")
    @RequestWrapper(localName = "getBamConfiguration", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetBamConfiguration")
    @WebMethod(action = "urn:getBamConfiguration")
    @ResponseWrapper(localName = "getBamConfigurationResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetBamConfigurationResponse")
    public java.lang.String getBamConfiguration(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName
    );

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:getStoppedWebapp", output = "urn:getStoppedWebappResponse")
    @RequestWrapper(localName = "getStoppedWebapp", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetStoppedWebapp")
    @WebMethod(action = "urn:getStoppedWebapp")
    @ResponseWrapper(localName = "getStoppedWebappResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetStoppedWebappResponse")
    public org.wso2.carbon.webapp.mgt.xsd.WebappMetadata getStoppedWebapp(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName
    );

    @Oneway
    @Action(input = "urn:expireSessionsInWebapps")
    @RequestWrapper(localName = "expireSessionsInWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.ExpireSessionsInWebapps")
    @WebMethod(action = "urn:expireSessionsInWebapps")
    public void expireSessionsInWebapps(
        @WebParam(name = "webappFileNames", targetNamespace = "http://org.apache.axis2/xsd")
        java.util.List<java.lang.String> webappFileNames
    );

    @Oneway
    @Action(input = "urn:startAllWebapps")
    @RequestWrapper(localName = "startAllWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.StartAllWebapps")
    @WebMethod(action = "urn:startAllWebapps")
    public void startAllWebapps();

    @Oneway
    @Action(input = "urn:expireSessionsInWebapp")
    @RequestWrapper(localName = "expireSessionsInWebapp", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.ExpireSessionsInWebapp")
    @WebMethod(action = "urn:expireSessionsInWebapp")
    public void expireSessionsInWebapp(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName,
        @WebParam(name = "maxSessionLifetimeMillis", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.Long maxSessionLifetimeMillis
    );

    @Oneway
    @Action(input = "urn:deleteWebapp")
    @RequestWrapper(localName = "deleteWebapp", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DeleteWebapp")
    @WebMethod(action = "urn:deleteWebapp")
    public void deleteWebapp(
        @WebParam(name = "webappFileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappFileName
    );

    @Oneway
    @Action(input = "urn:reloadAllWebapps")
    @RequestWrapper(localName = "reloadAllWebapps", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.ReloadAllWebapps")
    @WebMethod(action = "urn:reloadAllWebapps")
    public void reloadAllWebapps();

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:getPagedWebappsSummary", output = "urn:getPagedWebappsSummaryResponse")
    @RequestWrapper(localName = "getPagedWebappsSummary", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetPagedWebappsSummary")
    @WebMethod(action = "urn:getPagedWebappsSummary")
    @ResponseWrapper(localName = "getPagedWebappsSummaryResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.GetPagedWebappsSummaryResponse")
    public org.wso2.carbon.webapp.mgt.xsd.WebappsWrapper getPagedWebappsSummary(
        @WebParam(name = "webappSearchString", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappSearchString,
        @WebParam(name = "webappState", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappState,
        @WebParam(name = "webappType", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappType,
        @WebParam(name = "pageNumber", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.Integer pageNumber
    );

    @WebResult(name = "return", targetNamespace = "http://org.apache.axis2/xsd")
    @Action(input = "urn:downloadWarFileHandler", output = "urn:downloadWarFileHandlerResponse")
    @RequestWrapper(localName = "downloadWarFileHandler", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DownloadWarFileHandler")
    @WebMethod(action = "urn:downloadWarFileHandler")
    @ResponseWrapper(localName = "downloadWarFileHandlerResponse", targetNamespace = "http://org.apache.axis2/xsd", className = "axis2.apache.org.xsd.DownloadWarFileHandlerResponse")
    public byte[] downloadWarFileHandler(
        @WebParam(name = "fileName", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String fileName,
        @WebParam(name = "webappType", targetNamespace = "http://org.apache.axis2/xsd")
        java.lang.String webappType
    );
}
