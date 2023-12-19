CICD Project with Jenkins:  
==========================

# Install applications needed: 
- Install git: 
  https://git-scm.com/downloads 

  - Configure git: 
    - git config --global user.name "gitHub-User-Name"
    - git config --global user.email "gitHubEmail"

- Create an account with gitHub: 
  https://github.com/ 

- Docker Engine: 
  - Docker Desktop 
  https://docs.docker.com/desktop/install/windows-install/ 

  - docker ps: test whether docker is installed 
  - docker --version 

- Java 
  https://www.java.com/download/ie_manual.jsp 

- Jenkins (as a container) (port=8181) 
  - Pull Jenkins Image: 
    docker pull jenkins/jenkins:lts
  - Then run the container 
    docker run -p 8080:8080 -p 50000:50000 -v jenkins:/var/jenkins_home --name jenkins -d jenkins/jenkins:lts

User=admin 
Passwd: 

Get into Jenkins container: 
 - docker exec -it jenkins /bin/bash 
 - cat filepath 


- Sonarqube (as a container) (port=9000)
  - Pull Jenkins Image:
    docker pull sonarqube 
  - Run the container 
    docker run -d --name sonarqube -p 9000:9000 sonarqube 

  - To access sonarqube on the browser
    - Need IP 
      ipconfig 
      (192.168.254.106:9000)
    - user=admin 
    - passwd=admin 

- Nexus (as a container) (port=8082)
  - Run the container 
    docker run -d -p 8082:8081 --name nexus-repo-service -v C:/Nexus/nexus-data:/nexus-data sonatype/nexus3:3.38.0
  Get into Nexus container: 
    - docker exec -it nexus-repo-service /bin/bash 
    - cat filepath



- GitHub (git) = SCMT  
- Jenkins = (CICD)
- Maven = Build/package 'Java applications' 
- Sonarqube = scan codes 
- Nexus = Backup our build artifact (optional)
- Tomcat = (to host our application)

- Docker = to create docker images
           to run containers 
- DockerHub = to backup our images  



- git = versioning 
- github = manage our sorce code 
- maven = build our code to build artifact 
- sonarqube = scan out built artifacts 
- nexus (optional) = store our built artifact
- tomcat = host our application (web server) 
- jenkins = CICD
- docker = create images from our built artifact 
- dockerhub = store our docker images 
- docker = run our containers 
- kubernetes = manage our containers 

- ansible = configuration and provisioning 
- terraform = provisioning 


working area/environmet: 
 - git add . = add all the files in the present working directory 
 - git add fileName = add the selected file 
 - git add file1 file4 = add selected files 
staging area: 
 - git commit -m "commit message"  
production area 
 - git push github-URL branchName 
   git push git remote add origin https://github.com/vlonje20/jenkins-CICD.git main 
 - git remote add aliasName url 
 - git push aliasName branchName 


 source code 
 build script
    maven=pom.xml (Project Object Model)  
 test cases (optional)

 create docker image 
 Dockerfile

# App Final Name 
  jenkins-app

# Note:
  - Still working on the project 
