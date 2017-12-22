# Application setup on CentOS 7

## Update packages
```
yum update
```

## Download Java
```
wget --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u151-b12/e758a0de34e24606bca991d704f6dcbf/jdk-8u151-linux-x64.rpm
```

## Install Java
```
yum localinstall jdk-8u151-linux-x64.rpm
```

##Check java version
```
java -version
```

## Delete jdk-8u151-linux-x64.rpm
```
rm jdk-8u151-linux-x64.rpm
```

## Add JAVA_HOME
```
Edit ~/.bash_profile

export JAVA_HOME=/usr/java/jdk1.8.0_151
export JRE_HOME=/usr/java/jdk1.8.0_151/jre

PATH=$PATH:$HOME/bin:$JAVA_HOME/bin

export PATH
```

## Affect Changes
```
source .bash_profile
```

## Download Tomcat
```
cd ~
wget http://redrockdigimark.com/apachemirror/tomcat/tomcat-8/v8.5.24/bin/apache-tomcat-8.5.24.tar.gz
mkdir /opt/tomcat
tar xvf apache-tomcat-8.5.24.tar.gz  -C /opt/tomcat --strip-components=1
```

## Install GIT 
```
yum install git
```

## Install Maven
### Add repo
```
wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
```

### Install
```
yum install apache-maven
```

## Install Docker
### Download Community Edtion(CE) package:
```
wget https://download.docker.com/linux/centos/7/x86_64/stable/Packages/docker-ce-17.09.1.ce-1.el7.centos.x86_64.rpm
```

## Install Docker 
```
yum install docker-ce-17.09.1.ce-1.el7.centos.x86_64.rpm
```

## Check Docker Version
```
docker --version (Used : Docker version 17.09.1-ce, build 19e2cf6)
```

## Start Docker Service
```
service docker start
```