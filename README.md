WSO2 Deployer MOJO (Maven Plug In)
==================================
Idea: Deploy to WSO2 server and clusters using Maven

    <build>
      <plugins>
        <plugin>
          <groupId>org.mh.mojo.wso2deployment</groupId>
          <artifactId>wso2deployment-maven-plugin</artifactId>
          ...
          <configuration>
            <environment>
              <serverconfig>
                <serverId>as01</serverId>
                <serverUrl>https://localhost:9443/services/</serverUrl>
                <adminUser>admin</adminUser>
                <adminPassword>...</adminPassword>
              </serverconfig>
              ... (add as many servers you need)
            </environment>
            <deployments>
              <deployment>
                <serverId>as01</serverId>
                <groupId>org.mh</groupId>
                <artifactId>TestApp</artifactId>
                <version>1.2.3</version>
                <artifactType>war</artifactType>
              </deployment>
              ... (deploy to all servers as required) 
            </deployments>
          </configuration>			
        </plugin>
        ...
      </plugins>
    </build>

Build From Source
=================
<pre>
git clone https://github.com/ma-ha/WSO2-Deployer-Maven-Plugin.git
cd WSO2-Deployer-Maven-Plugin
mvn clean install -Dmaven.test.skip=true
</pre>

Prepare
=======
Since the WSO2 servers come with self signed certificates the web service will fail, so you have to import the certificate into you certificate store:

1. Start the WSO2 Server and open the carbon console in the browser.
2. Copy the SSL certificate from the browser to a local file, e.g. wso2-as.cert
3. Load the certificate into your key store (it will go to ~/.keystore by default):<br><code>keytool -import -trustcacerts -alias wso2as-key -file wso2-as.cert</code>

Run Test
========
For this test you need to install the test artifacts into your local repository. For this test we take these, coming with the WSO2 AS:
<pre>
mvn install:install-file -DgroupId=test -DartifactId=WarTest -Dversion=1.0.0 -Dpackaging=war -Dfile=/<path-to-wso2as>/wso2as-5.2.0/repository/deployment/server/webapps/example.war
mvn install:install-file -DgroupId=test -DartifactId=AarTest -Dversion=1.0.0 -Dpackaging=aar -Dfile=/<path-to-wso2as>/wso2as-5.2.0/repository/deployment/server/axis2services/HelloWorld.aar
</pre>
A CAR is not provided, so I provided one here (don't hesitate -- it contains an empty dummy config, w/o any application)
<pre>
mvn install:install-file -DgroupId=test -DartifactId=CarbonAppTest -Dversion=1.0.0 -Dpackaging=car -Dfile=CarbonAppTest.car
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