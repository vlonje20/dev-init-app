# Jenkins Installation

- Install Jenkins as a container:  
  - Pull Jenkins Image: 
    docker pull jenkins/jenkins:lts
  - Then run the container 
    docker run -p 8080:8080 -p 50000:50000 -v jenkins:/var/jenkins_home --name jenkins -d jenkins/jenkins:lts

User=admin 
Passwd: 


Default port=8080
Exposed port=8181


To get the administrator password:
==================================
Get into Jenkins container: 
 - docker exec -it jenkins /bin/bash  OR 
 - docker exec -it jenkins bash
 - cat filepath 