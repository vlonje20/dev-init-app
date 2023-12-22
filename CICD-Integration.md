# CICD Jenkins Integration:
===========================

# 1. Jenkins GitHub Intergrations:  
  - Go to Dashboard and create a 'new project' (+ New Item)
  - Enter 'jenkins project' name and select Freestyle project and click OK 
  - Under "Source Code Management", select Git 
  - Copy the GitHub project URL and paste on Repository URL. 
  - Set your Credentials: 
    - Under Credentials, select '+Add' then Jenkins
    - Leave Domain, Kind and Scope as default
    - Under username, input your jenkins username and password
    - Input your description and select Add
  - Now Under Credentials replace -none- with your credentials 
  - Under 'Branches to build' input your production branch 
  - Now Save 
  - Select 'Build Now'


# 2. Jenkins Maven Intergrations:  
  - Dashboard ==> Manage Jenkins ==> Tools ==> Add Maven 
  - Under Name, write maven+highest-version 
    For instance maven3.9.6
  - Now Save

  - Dashboard ==> Project ==> Configure ==> Build Steps ==> 
    Add Build Step ==> Invoke-top-level Maven Targets 
  - Under 'Maven Version', select your preconfigured maven version.
  - Under 'Goal' write 'clean package' 
  - Now Save
  - Select 'Build Now'


# 3. Jenkins SonarQube Intergrations (Code Quality) 
  # On GitHub:  
  - Make sure your SonarQube Server is running 
  - Go to the Build Script (pom.xml) in the GitHub Repository
  - Go to 'Properties' and change the sonar.host.url (IP addressPort) and replace with the 
    right IP addressPort of your SonarQube Server. 
  - Commit the changes. 

     # On Jenkins:  
  - Go to Dashboard ==> yourProject ==> Configure ==> Build Steps ==> Add Build Step ==> 
    Invoke-top-level Maven Targets
  - Under 'Maven Version', select your preconfigured maven version.
  - Under 'Goal' write 'sonar:sonar'
  - Then Save 
  - Build Now    

# 4. Jenkins Tomcat Intergrations 
 - We do this intergration using a plugin call 'Deploy to Container'  
 - In Jenkins go to Dashboard ==> Manage Jenkins ==> Manage Plugins ==> 
   Available ==> Search "Deploy to container"
 - Select and install

 - Dashboard ==> Project ==> Configure ==> Post-Build-Actions ==> Add Post-Build-Action ==> 
   Deploy war/ear to container ==>

 - Under 'Deploy war/ear to a container'
   target/*.war              /*OR   
   target/yourBuildscript                                           

 - Add Container ==> Chose Tomcat Version (It should be the latest stable version) 

 - Under Containers/Tomcat 9.x Remote 
   - add new credentials
   - use your tomcat credentials that you will configure in the 'tomcat-users.xml'
   - Follow the steps below to create your user in 'tomcat-users.xml'

 # To create your tomcat credentials: 
 - On your terminal do the following: 

     sudo nano /etc/tomcat9/tomcat-users.xml 

 - Paste the following just above the </tomcat-users> closing.

     <user username="tomcat" password="admin123" roles="manager-gui,admin-gui"/>
     <user username="vin" password="admin123" roles="manager-gui,admin-gui,manager-script"/> 

 - Under Tomcat URL 
   - Copy and paste your tomcat url


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





