FROM jboss/wildfly
COPY target/StudentApp/WEB-INF/classes/configuration/standalone-custom.xml /opt/jboss/wildfly/standalone/configuration/
COPY target/StudentApp/WEB-INF/classes/configuration/sqljdbc42.jar /opt/jboss/wildfly/modules/system/layers/base/com/microsoft/sqlserver/jdbc/main/
COPY target/StudentApp/WEB-INF/classes/configuration/module.xml /opt/jboss/wildfly/modules/system/layers/base/com/microsoft/sqlserver/jdbc/main/
COPY target/StudentApp.war /opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-custom.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
