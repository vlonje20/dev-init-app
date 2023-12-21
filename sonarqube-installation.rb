# Sonarqube Installation: 
 
- Install Sonarqube as a container: 
  - Pull Jenkins Image:
    docker pull sonarqube 
  - Run the container 
    docker run -d --name sonarqube -p 9000:9000 sonarqube 

  - To access sonarqube on the browser
    - Need IP (run the below command to get the IP) 
      ipconfig 
      (192.168.254.106:9000)

Default Login:
    - user=admin 
    - passwd=admin 

Default por=9000


======================================

- Nexus (as a container) (port=8082)
  - Run the container 
    docker run -d -p 8082:8081 --name nexus-repo-service -v C:/Nexus/nexus-data:/nexus-data sonatype/nexus3:3.38.0
  Get into Nexus container: 
    - docker exec -it nexus-repo-service /bin/bash 
    - cat filepath