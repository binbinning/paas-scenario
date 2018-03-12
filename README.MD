简单的web应用说明端到端的paas应用场景。

# 应用说明
JavaEE web应用，模拟用户增删改查。
运行：
git clone https://github.com/binbinning/paas-scenario.git
mvn clean packge
mvn jetty:run
	note: ${URLEncoder.encode(user.getUsername(), "utf-8")} does not work with jetty:run

deploy to tomcat:
	cp target/paas-scenario.war ${CATALINA_HOME}/webapps

access: localhost:8080/paas-scenario.   
    
# PaaS平台运行说明
sh run.sh to build docker image and push to repository
kubernetes deployment