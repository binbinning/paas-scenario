#FROM tomcat:8.5.28-jre8 
#FROM tomcat:8.5.28-jre8-slim 
FROM tomcat:8.5.28-jre8-alpine
MAINTAINER binbinning 
COPY target/paas-scenario.war $CATALINA_HOME/webapps
