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

# Default Login:
    - user=admin 
    - passwd=admin 

# Default Port 
    - port=9000

# Get into a container: 
 - docker exec -it containerName /bin/bash 
 - docker exec -it containerName bash

