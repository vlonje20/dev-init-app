# CICD Jenkins Integration:
===========================

# 1. Jenkins GitHub Intergrations:  
  - In Jenkins, Go to Dashboard and create a 'new project' (+ New Item).
  - Enter 'jenkins project' name and select 'Freestyle project' and click OK.
  - Under Github project/Project url, paste your 'Github Project URL'  
  - Under "Source Code Management", select Git. 
  - Copy the 'GitHub Repository URL' and paste on Repository URL. 
  - Set your Credentials: 
    - Under Credentials, select '+Add' then Jenkins.
    - Leave Domain, Kind and Scope as default.
    - Under username, input your jenkins username and password.
    - Input your description and select Add.
  - Now Under Credentials replace -none- with your credentials. 
  - Under 'Branches to build' input the branch you want to build from. 
  - Now 'Save' 
  - Select 'Build Now'


# 2. Jenkins Maven Intergrations: 
  - Configure Maven: 
    - In Jenkins, Dashboard ==> Manage Jenkins ==> Tools ==> Add Maven 
    - Under Name, write maven+highest-version (eg: maven3.9.6)
    - Now 'Save'

  - Build with Maven: 
    - In Jenkins, Dashboard ==> Project ==> Configure ==> Build Steps ==> 
      Add Build Step ==> Invoke-top-level Maven Targets 
    - Under 'Maven Version', select your preconfigured maven version.
    - Under 'Goal' write 'clean package' 
    - Now 'Save'
    - Select 'Build Now'


# 3. Jenkins SonarQube Intergrations: (Code Quality) 
  # On SonarQube:
  - Generate a Token:
    - Go to Administration ==> Click the dropdown on Security ==> Users
    - Click under 'Token'
    - Enter Name under 'Name', Chose Duration then click 'Generate' 
    - Copy Token and Backup for you won't be able to see or copy it again. 

    OR
     
    - Go to 'Account' on the top right hand corner and click 'My Account'
    - Security 
    - Fill the appropriate input and click 'Generate'
    - Under 'Type', select 'Global Analysis Token'
    - Remember to backup your token 


  # On GitHub:  
  - Go to the Build Script (pom.xml) in the GitHub Repository
  - Go to 'Properties' and add/edit the following: 
    
    <sonar.host.url>your-sonarqube-url</sonar.host.url>
    <sonar.login>your-username</sonar.login>
    <sonar.password>your-password</sonar.password>
    <sonar.projectKey>your-sonarqube-token</sonar.projectKey>
    <sonar.projectName>your-project-name</sonar.projectName>

  - your-project-name: This is what will appear in SonarQube
  - Commit the changes. 


  # On Jenkins: 
  - Download and Install SonarQube Plugins: 
    - Dashboard ==> Manage Jenkins ==> Plugins
    - Available Plugins ==> SonarQube Scanner for Jenkins 
    - Select and install without restart 

  - Configure SonarQube: 
    - Dashboard ==> Manage Jenkins ==> System 
    - Scroll down to SonarQube Servers and click 'Add SonarQube' 
    - Check 'Environmental Variables'
    - Input the following: 
      - Name: your-name 
      - Server URL: your server URL (eg: http://localhost:9000)
      - Server authentication token: 
        - Click the +Add button below ==> Jenkins 
        - Domain: leave as it is
        - Kind: Secret text 
        - Scope: leave as it is 
        - Username: your-username (eg: admin)
        - Password: your-sonarqube-token
        - ID: your-ID (eg: jenkins-sonar-cred)
        - Description: your-Description (eg: jenkins-sonar-cred)
        - Then click 'Add' 
      - Server authentication token:
        - Select what you just created.
    - Now 'Save' 

  - Run Your Job:
    - Go to Dashboard ==> yourProject ==> Configure ==> Build Steps ==> Add Build Step ==> 
      Invoke-top-level Maven Targets
    - Under 'Maven Version', select your preconfigured maven version.
    - Under 'Goal' write 'sonar:sonar'
    - Then 'Save' 
    - Build Now    

# 4. Jenkins Nexus Integration: (Artifact Backup)
  - Configure Nexus: 
   (a) Repositories
    - Sign in to nexus and click 'Server administration and configuration' 
    - Open Repository ==> Create Repository ==> maven2 (hosted):
       - Name: your repository name 
       - Version policy: Mixed
       - Layout policy: Strict
       - Content Disposition: Inline
       - Blob store: default
       - Deployment policy: Allow redeploy
    - Click 'Create repository'

    (b) Users: 
    - Click 'Create local user'
    - Fill out the form 
    - At the bottom under 'Roles', select nx-admin from column 1 and pushed to column 2 
    - Then click 'Create local user'

  - Configure Jenkins: 
    - In Jenkins, go to Dashboard ==> Manage Jenkins ==> Plugins 
    - Available Plugins and search 'Nexus Artifact Uploader'
    - Install without restart 

    - Go to your project ==> Configure ==> Build Steps ==> Add build steps
    - Nexus artifact uploader 
      - Nexus artifact uploader
      - Nexus Details
        - Nexus Version: NEXUS3
        - Protocol: HTTP
        - Nexus UR: your nexus URL without the http/https: (eg: localhost:8081)
        - Credentials: use the user credentials you earlier configured in Nexus
        - GroupId: your project name - what will appear in nexus (eg: jenkins-app): 
        - Version: your version number (eg: 1.0-SNAPSHOT)
        - Repository: The repository you created in Nexus 

    - Artifacts ==> Add
      - ArtifactId: your ID. Subfolder inside your 'GroupId' (Your project name version. eg: jenkins-app-v1.0.0)
      - Type: war
      - Classifier: leave blank 
      - File: Get the complete link of your .war file on your backend. Default link could be found in: /var/lib/jenkins/ (eg: /var/lib/jenkins/workspace/your-project-name/target/jenkins-app-v1.0.0.war)

# 5. Jenkins Tomcat Integrations: 
 - We do this intergration using a plugin call 'Deploy to Container'  
 - In Jenkins go to Dashboard ==> Manage Jenkins ==> Plugins ==> 
   Available ==> Search "Deploy to container"
 - Select and install without restart

 - Dashboard ==> Project ==> Configure ==> Post-Build-Actions ==> Add Post-Build-Action ==> 
   Deploy war/ear to container ==>

 - Under 'Deploy war/ear to a container'
   - WAR/EAR files: 
     target/*.war              /*OR   
     target/your-built-artifact.war 
   - Context path: leave blank   
                                         
 - Add Container ==> Chose Tomcat Version (It should be the latest stable version) 

 - Under Containers/Tomcat 9.x Remote 
   - add new credentials
   - use your tomcat credentials that you will configure in the 'tomcat-users.xml'
   - Follow the steps below to create your user in 'tomcat-users.xml'

 # To create your tomcat credentials: 
 - On your terminal do the following: 

     $ sudo nano /etc/tomcat9/tomcat-users.xml 

 - Paste the following just above the </tomcat-users> closing.

     <user username="tomcat" password="admin123" roles="manager-gui,admin-gui"/>
     <user username="vin" password="admin123" roles="manager-gui,admin-gui,manager-script"/> 

 - Under Tomcat URL 
   - Copy and paste your Tomcat URL

 - Save 
 - Build Now


# 6. Email Notification 
  - In Jenkins go to Dashboard --> Project --> Configure --> Post-Build-Action --> 
    Add Post-Build-Action --> Email Notification --> Emails --> Build Now  


Build Triggers: 
===============
- We use build triggers to automate the process.  
- Build Now          
  - This is a manual build 

- Build Periodically 
  - Jenkins uses a timer to trigger a build. 
    (***** build every minute) 
    (H**** build every hour) 
    (Best for Database backup)

- Poll SCM           
   - Jenkins trigger a build based on changes in the source codes. 
     (Generally Recommended) 
   - Jenkins pull the changes from GitHub.   

- GitHub Web Hook    
   - Jenkins do a build when there is any changes in the source code 
   (GitHub Account) 
   - GitHub push the changes to Jenkins.  
   - To configure = GitHub--> Project Repo--> Settings--> Webhooks-->  Add Webhook 
     Content type = (application/json)
     Payload URL = Paste the Jenkins URL with the extension github-webhook/ 
     (e.g. http://18.218.211.120:8080/github-webhook/)
