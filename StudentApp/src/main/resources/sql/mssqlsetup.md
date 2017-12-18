docker pull microsoft/mssql-server-linux:2017-latest
docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Welcome@123" --name "sqlserver-instance" -p 1401:1433 -d microsoft/mssql-server-linux:2017-latest

docker exec -it sqlserver-instance /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P "Welcome@123"

> CREATE database studb
> go
> USE studb
> go
> CREATE SCHEMA student
> CREATE TABLE student.STUDENT (ID INT IDENTITY(1,1) NOT NULL,	NAME VARCHAR(30) NOT NULL, AGE INT NOT NULL, STANDARD VARCHAR(5) NOT NULL, SECTION VARCHAR(5) NOT NULL, CONSTRAINT PK_INFO PRIMARY KEY (ID))