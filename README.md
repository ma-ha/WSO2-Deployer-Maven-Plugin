Build
=====
git clone https://github.com/ma-ha/WSO2-Deployer-Maven-Plugin.git
cd WSO2-Deployer-Maven-Plugin
mvn clean install -Dmaven.test.skip=true


Run Test
========

cd src/test/projects/project2
mvn deploy:wso2
