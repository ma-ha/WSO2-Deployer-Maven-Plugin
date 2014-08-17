Build From Source
=================
<pre>
git clone https://github.com/ma-ha/WSO2-Deployer-Maven-Plugin.git
cd WSO2-Deployer-Maven-Plugin
mvn clean install -Dmaven.test.skip=true
</pre>

Run Test
========
<pre>
cd src/test
mvn deploy:wso2
</pre>

Usage
=====
Please use the <code><a href="blob/master/src/test/pom.xml">src/test/pom.xml</a></code> as example 
to configure your own deployments.

If you use WSO2 clusters, you may have to define server roles and deploy each artifact to all managers, 
so that it goes to each node and the node itself decides which artifact part to deploy.  