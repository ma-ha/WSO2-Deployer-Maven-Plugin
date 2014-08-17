Important notice: current version 0.2 can deploy WAR files only. I'll add the other deployment modules if I have some time.

Build From Source
=================
<pre>
git clone https://github.com/ma-ha/WSO2-Deployer-Maven-Plugin.git
cd WSO2-Deployer-Maven-Plugin
mvn clean install -Dmaven.test.skip=true
</pre>

Run Test
========
For this test you need to install a <code>CRM-0.1.0.war</code> into your local repository.
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