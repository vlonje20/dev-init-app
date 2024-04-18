### Install Jenkins on a server:
Server Type: Ubuntu <br>
Check out [Here](https://www.jenkins.io/doc/book/installing/linux/#debianubuntu 
) for guidance:  
 
Become root:
```
sudo -i 
```

Update and Upgrade the server:
```
apt update 
```
```
apt upgrade -y 
```
Create a Jenkins user: 
```
adduser jenkins
``` 
Disable password and add jenkins to the Sudoers group: 
```
echo "jenkins ALL=(ALL) NOPASSWD:ALL" | sudo tee /etc/sudoers.d/jenkins
```
| OR |
```
echo "jenkins ALL=(ALL) NOPASSWD:ALL" > /etc/sudoers.d/jenkins
```

Switch to jenkins user:
```
su - jenkins 
```

Install Java:
``` 
sudo apt update
```
```
sudo apt install fontconfig openjdk-17-jre -y
```
Check Java version:
```
java -version
```

Install Jenkins | Get neccessary plugins: 
```
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian/jenkins.io-2023.key
```
```
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
```
Update the server:
```
sudo apt update
```
Install Jenkins: 
```
sudo apt install jenkins
```

Check Jenkins status:
``` 
sudo systemctl status jenkins
```

If jenkins is not running then enable it:
``` 
sudo systemctl enable jenkins
```

Now start it:
```
sudo systemctl status jenkins
```
Then check the status again:
```
sudo systemctl status jenkins
```
##
Open Jenkins on the web: 
  - Jenkins default port = 8080
  - Get your instance IP from the consold 
  - Then user IP:portNumber to access jenkins on the web.
##
Unlock Jenkins: 
```
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```
Get the Administrator Password 
##

### Install Jenkins as a container:  
Pull Jenkins Image from DockerHub: 
```
docker pull jenkins/jenkins:lts
```
Then run the container:
``` 
docker run -p 8080:8080 -p 50000:50000 -v jenkins:/var/jenkins_home --name jenkins -d jenkins/jenkins:lts
```

Login:
- User=admin 
- Passwd=yourpasswd

Ports:
- Default port=8080
- Exposed port=8181 (or chose your expose port)

##
To get the administrator password:
Get into Jenkins container: 
```
docker exec -it jenkins /bin/bash
```
| OR |
```
docker exec -it jenkins bash
```
```
cat filepath 
```

##

### Troubleshooting: 
- If jenkins fails to integrate with git under 'Source Code Management' <br>
  Do the following to resolve this: 
- On your terminal, edit the Jenkins DNS configuration file using the command:
```
sudo nano /etc/resolv.conf 
```

- Add the following line to use Google DNS:
```
nameserver 8.8.8.8
```
- Save the file and restart Jenkins service:
```
sudo systemctl restart jenkins
```
- Go to Jenkins and try the integration again 
##

### How to change Jenkins default portNumber: 
Locate the Jenkins configuration file:
```
cd /etc/default/ 
```
```
sudo nano jenkins 
```

Or use the direct path: 
``` 
sudo nano /etc/default/jenkins 
```
  
- Look for the line that specifies the HTTP_PORT variable. <br> 
  For example, it may look like HTTP_PORT=8080.

- Change the port number to the desired value. <br> 
  Make sure it is a valid and available port.

- Add a new line below HTTP_PORT=-1 to set your desired port using <br> 
  the --httpPort option. For example:
```
HTTP_PORT=-1
JENKINS_ARGS="--httpPort=8081"
```

- Save the changes to the configuration file and exit the text editor.
- Restart the Jenkins service to apply the changes. 
```
sudo systemctl restart jenkins
```

Edit the 'jenkins.service' file:
```
sudo nano /lib/systemd/system/jenkins.service
```

- Change the port on the file <br>
  [Service] <br>
  Environment="JENKINS_PORT=8081"

Reload the daemon and restart jenkins service:
```
sudo systemctl daemon-reload
sudo service jenkins restart
```
##
If you are using UFW (Uncomplicated Firewall) on Ubuntu, you can allow incoming <br> 
connections to the port with the following command:
```
sudo ufw allow 8081
```
## 