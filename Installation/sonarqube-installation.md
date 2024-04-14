### Sonarqube Installation: 
Install Sonarqube as a container: 
- Pull Jenkins Image:
```
docker pull sonarqube 
```
- Run the container:
``` 
docker run -d --name sonarqube -p 9000:9000 sonarqube 
```
To access sonarqube on the browser:
- Need IP (run the below command to get the IP) 
```
ipconfig
``` 
Access from the web:
- IP:Port
- (192.168.254.106:9000)

Default Login:
- user=admin 
- passwd=admin 

Default Port 
- port=9000

Get into a container: 
```
docker exec -it containerName /bin/bash
```

| OR |

```
docker exec -it containerName bash
```

##
### Sonarqube Jenkins: 
To integrate SonarQube scanner into a Jenkins freestyle job, you can follow these steps:

1. Install the SonarQube Scanner plugin:

- Go to Jenkins dashboard.
- Click on "Manage Jenkins" on the left sidebar.
- Select "Manage Plugins" from the dropdown.
- Navigate to the "Available" tab.
- Search for "SonarQube Scanner" plugin.
- Check the checkbox next to the plugin and click "Install without restart" button.

2. Configure SonarQube server:

- Go to Jenkins dashboard.
- Click on "Manage Jenkins" on the left sidebar.
- Select "Configure System" from the dropdown.
- Scroll down to the "SonarQube" section.
- Click on "Add SonarQube" button.
- Enter a name and the SonarQube server URL.
- Provide the necessary credentials or authentication token if required.
- Save the configuration.

3. Configure the SonarQube scanner in the Jenkins job:

- Open the Jenkins job configuration.
- Under the "Build" section, click on "Add build step" dropdown.
- Select "Execute SonarQube Scanner" from the dropdown.
- In the "Analysis properties" field, specify the required SonarQube properties. For example:
    sonar.projectKey=my-project <br>
    sonar.sources=src <br>
    sonar.tests=test <br>
    sonar.junit.reportPaths=reports/junit/**/*.xml <br> 
- Save the job configuration.


4. Trigger the Jenkins job:
- Go to the Jenkins dashboard.
- Select the desired Jenkins job.
- Click on "Build Now" to trigger the job.

Jenkins will now run the SonarQube scanner during the build process and provide analysis reports in the SonarQube server.
##