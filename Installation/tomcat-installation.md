### Tomcat Installation: 

Become root:
``` 
sudo -i
```
Update the server: 
```
apt update 
```
Upgrade the server: 
```
apt upgrade -y 
```

Install Java as pre-requisite: 
```
apt install default-jdk -y 
```
Create tomcat user: 
```
adduser tomcat 
```
Allow the tomcat user to run all commands with sudo without password:
```
echo "tomcat ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/tomcat
```
Switch to tomcat user: 
```
su - tomcat   
```
##
Install tomcat: 
```
sudo apt install tomcat9 -y 
``` 
Get to the path to start tomcat: 
```cd /etc/tomcat9  
```
Start tomcat:
``` 
sudo systemctl enable tomcat9
```
```
sudo systemctl start tomcat9
```
```
sudo systemctl status tomcat9
```
Test on server:
Get the IP:
```  
curl ifconfig.me
``` 
Default Port:8080

Install Dependences:
tomcat9-docs: 
```
sudo apt install tomcat9-docs -y 
```
tomcat9-examples: 
```
sudo apt install tomcat9-examples -y
```
tomcat9-admin: 
```
sudo apt install tomcat9-admin -y
```
## 

Set Your User Credentials: 
Path to edith manager-gui/admin-gui:  
```
sudo nano /etc/tomcat9/tomcat-users.xml
```
Paste the following, save and exit: 
```
<role rolename="admin-gui"/>
<user username="admin" password="passwd" roles="admin-gui"/>

<role rolename="manager-gui"/>
<user username="tomcat" password="passwd" roles="manager-gui"/>
```
##

Tomcat Deployment: <br>
Copy build artifacts to tomcat webservers:
```
sudo scp target/*war /var/lib/tomcat9/webapps
```
##
Maven Installation: 
```
sudo apt install maven -y 
```
To check if maven is installed 
```
mvn --version
```
##