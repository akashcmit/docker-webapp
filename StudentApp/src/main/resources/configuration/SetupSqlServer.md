
#Introduction
This document describes the setup of Microsoft SQL Server 2014 Developer Edition in a Local Windows 10 Machine.

##Initial Setup

 1. Download and install MS SQL Server Developer Edition 
 2. Download and install Ms SQL Management Studio 
 3. Create a new Database before proceeding (ex. student-db)

	

## Create new Login
By default SQL Server is configured to allow Windows Authentication only. In order to connect with an app (Java/Wildfly), SQL Authentication needs to be switched on.

	

 1. Login to Management Studio using windows authentication 
 2. Expand
    master instance -> Right click Security and Add New LOGIN
 3. Select SQL Server authentication
 4. Provide user name and password
 5. Un-check Enforce Password Expiration
 6. Go to Server Roles in left panel and check all applicable roles
    (makes sense to check all for ADMIN)
 7. Go to User Mapping in left panel and select databases for which this
    user will be allowed access
 8. Hit enter to finally create the user
 9. Test this LOGIN by connecting to server with new credentials

	

##Enable TCP/IP Network Access
By default all TCP/IP connections to an SQL server are disabled. To enable them (in order to connect with an application)

	

 1. Go to Computer Management (in Control Panel)
 2. Expand SQL Server Configuration Manager -> Expand SQL Server Network
    Configuration -> Select Protocols for MSSQLSERVER
 3. Double Click TCP/IP Protocol
 4. In General Tab -> Select ENABLED to TRUE and LISTEN ALL to YES
 5. In IP Addresses Tab -> In all IP types -> Select ACTIVE to YES and
    ENABLED to YES
 6. By default, a common Port Number is assigned to all IP types ~ 1433.
    This is the port number of the server. (Could be changed if
    required)
 7. After making the above changes, it is mandatory to restart the SQL
    server as below:
    
    

> 	Open CMD/PowerShell as administrator
>     net stop mssqlserver
>     net start mssqlserver

	


##Connect using Wildfly 10
We will try to connect to the server using Wildfly 10 application server by creating a datasource configuration.

 1. Download sqljdbc42.jar from official site
 2. Download and extract Wildfly 10
 3. Create following directory structure (if not exists) in Wildfly ->
 
 > wildfly-10\modules\system\layers\base\com\microsoft\sqlserver\jdbc\main
 
 4. Keep the sqljdbc42.jar in this folder
 5. Create an xml file in the same directory - module.xml and paste the following content

				 <module xmlns="urn:jboss:module:1.3" name="com.microsoft.sqlserver.jdbc">
		     		  <resources>
		     		    <resource-root path="sqljdbc42.jar"/>
		     		  </resources>
		     		  <dependencies>
		     		    <module name="javax.api"/> 
		     		    <module name="javax.transaction.api"/> 
		     		    <module name="javax.xml.bind.api"/>
		     		  </dependencies>
		     		</module>

 6. Go to wildfly/standalone/configuration and edit standalone.xml
 7. Add new driver configuration as below

		    <driver name="sqlserver" module="com.microsoft.sqlserver.jdbc">
    	        <driver-class>com.microsoft.sqlserver.jdbc.SQLServerDriver</driver-class>
    	    </driver>

 8. Add new datasource configuration as below

		<datasource jta="true" jndi-name="java:jboss/datasources/MyDS" pool-name="MyDS" enabled="true" use-java-context="true" use-ccm="true">
        <connection-url>jdbc:sqlserver://localhost:1433;databaseName=student-db</connection-url>
        <driver>sqlserver</driver>
        <pool>
            <min-pool-size>1</min-pool-size>
            <max-pool-size>5</max-pool-size>
            <prefill>true</prefill>
        </pool>
        <security>
            <user-name>username</user-name>
            <password>password</password>
        </security>
    	</datasource>

 9. Use the username and password created while creating the LOGIN
 10. Save the standalone.xml and start wildfly by running ./standalone.bat in wildfly/bin
 11. Keep the wildfly terminal running and open a new terminal
 12. Go to wildfly/bin and run $ jboss-cli.bat which is command line utility for wildfly
 13. In the prompt write - $ connect and you will be connected to running wildfly server
 14. Then give the command to test the DB connection

		/subsystem=datasources/data-source=MyDS:test-connection-in-pool

 15. The output must print
		

		 {
			 "outcome" => "success",
			 "result" => [true]
		 }

 16. This shows the connection to the db was successful. If any errors happen, they will be reflected in wildfly logs. Check them and resolve.
	
		