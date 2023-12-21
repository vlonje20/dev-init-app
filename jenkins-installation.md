# Jenkins Installation

# Install Jenkins on a server: 
https://www.jenkins.io/doc/book/installing/linux/#debianubuntu 

- severType = ubuntu 
- instanceType = t2.micro 

# Become root:
  - sudo -i 

# Update and Upgrade the server:
  - apt update 
  - apt upgrade -y 

# Create a user: 
  - sudo -i 
  - adduser newUser 

# Disable password and add newUser to the Sudoers group 
  - echo "newUser ALL=(ALL) NOPASSWD:ALL" | sudo tee /etc/sudoers.d/newUser  |OR|
  - echo "newUser ALL=(ALL) NOPASSWD:ALL" > /etc/sudoers.d/newUser

# Switch to newUser:
  - su - newUser 

# Install Java: 
sudo apt update
sudo apt install fontconfig openjdk-17-jre
java -version
openjdk version "17.0.8" 2023-07-18
OpenJDK Runtime Environment (build 17.0.8+7-Debian-1deb12u1)
OpenJDK 64-Bit Server VM (build 17.0.8+7-Debian-1deb12u1, mixed mode, sharing)

# Install Jenkins: 
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian/jenkins.io-2023.key
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins

# Start Jenkins:
 - Check Jenkins status: 
   sudo systemctl status jenkins

 - If jenkins is not running then enable it. 
   sudo systemctl enable jenkins
 
 - Now start it
   sudo systemctl status jenkins

 - then check the status again. 

# Open Jenkins on the web: 
  - Jenkins default port = 8080
  - Get your instance IP from the consold 
  - Then user IP:portNumber to access jenkins on the web.

# Unlock Jenkins: 
  - sudo cat /var/lib/jenkins/secrets/initialAdminPassword
  - Get the Administrator Password 


=============================================================

# Install Jenkins as a container:  
  - Pull Jenkins Image: 
    docker pull jenkins/jenkins:lts
  - Then run the container 
    docker run -p 8080:8080 -p 50000:50000 -v jenkins:/var/jenkins_home --name jenkins -d jenkins/jenkins:lts

# Login:
- User=admin 
- Passwd=yourpasswd

# Ports:
- Default port=8080
- Exposed port=8181 (or chose your expose port)


To get the administrator password:
==================================
Get into Jenkins container: 
 - docker exec -it jenkins /bin/bash  OR 
 - docker exec -it jenkins bash
 - cat filepath 