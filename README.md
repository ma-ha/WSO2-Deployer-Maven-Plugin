Important notice: current version 0.2 can deploy WAR files only. I'll add the other deployment modules if I have some time.

Build From Source
=================
<pre>
git clone https://github.com/ma-ha/WSO2-Deployer-Maven-Plugin.git
cd WSO2-Deployer-Maven-Plugin
mvn clean install -Dmaven.test.skip=true
</pre>

Prepare
=======
1. Start the WSO2 Server and open the carbon console in the browser.
2. Copy the SSL certificate from the browser to a local file, e.g. wso2-as.cert
3. Load the certificate into your keystore (it will go to ~/.keystore by default):<br><code>keytool -import -trustcacerts -alias wso2as-key -file wso2-as.cert</code>

Run Test
========
For this test you need to install a <code>CRM-0.1.0.war</code> into your local repository. And of course the WSO2 servers need to be running.
<pre>
cd src/test
mvn deploy:wso2
</pre>

Usage
=====
Please use the <code><a href="https://github.com/ma-ha/WSO2-Deployer-Maven-Plugin/blob/master/src/test/pom.xml">src/test/pom.xml</a></code> as example 
to configure your own deployments.

If you use WSO2 clusters, you may have to define server roles and deploy each artifact to all managers, 
so that it goes to each node and the node itself decides which artifact part to deploy.  