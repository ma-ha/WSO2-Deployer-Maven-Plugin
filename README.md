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
For this test you need to install the test artifacts into your local repository. For this test we take these, coming with the WSO2 AS:
<pre>
mvn install:install-file -DgroupId=test -DartifactId=WarTest -Dversion=1.0.0 -Dpackaging=war -Dfile=/<path-to-wso2as>/wso2as-5.2.0/repository/deployment/server/webapps/example.war
mvn install:install-file -DgroupId=test -DartifactId=AarTest -Dversion=1.0.0 -Dpackaging=aar -Dfile=/<path-to-wso2as>/wso2as-5.2.0/repository/deployment/server/axis2services/HelloWorld.aar
</pre>
A CAR is not provided, so I provided one here (don't hesitate -- it contains an empty dummy config, w/o any application)
<pre>
mvn install:install-file -DgroupId=test -DartifactId=CarbonAppTest -Dversion=0.0.1 -Dpackaging=car -Dfile=CarbonAppTest.car
</pre>
Of course then the WSO2 servers need to be running -- at least a WSO2 AS.
<pre>
cd src/test
mvn deploy:wso2
</pre>
The last deployment throws an exception from the stub, it can be ignored. It is a problem with the WSDL from the CAR service. 
WSO2 may have fixed this meanwhile.

Usage
=====
Please use the <code><a href="https://github.com/ma-ha/WSO2-Deployer-Maven-Plugin/blob/master/src/test/pom.xml">src/test/pom.xml</a></code> as example 
to configure your own deployments.

If you use WSO2 clusters, you may have to define server roles and deploy each artifact to all managers, 
so that it goes to each node and the node itself decides which artifact part to deploy.  