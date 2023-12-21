# CICD Jenkins Integration:

1. # Jenkins GitHub Intergrations:   
  - Copy the URL on GitHub and paste on Jenkins. 

2. # Jenkins Maven Intergrations:  
  - Dashboard ==> Manage Jenkins ==> Tool==> Add Maven [maven3.8.1] 
    Dashboard ==> Project ==> Configure ==> Build --> Add Build Step --> 
    Invoke-top-level Maven Targets --> Maven Version --> Goal (clean package) --> Build Now 
  - Maven Clean Package does: 
    validation / compilation / testing / packaging 

3. # Jenkins SonarQube Intergrations (Code Quality) 
  - Make sure your SonarQube Server is running 
  - Go to the Build Script (pom.xml) in the GitHub Repository
  - Go to Properties and change the sonar.host.url (IP addressPort) and replace with the 
    right IP addressPort of your SonarQube Server. 
  - Commit the changes.  
  - Go to Jenkins --> Configure --> Build --> Add Build Step --> 
    Invoke-top-level Maven Targets --> Goals (sonar:sonar) --> Build Now 
  * To Start SonarQube we need to go to the /bin directory
   - Become Sonar (sudo su - sonar) --> cd /opt --> ls --> cd sonarqube/ 
     --> ls --> ls bin/ --> ls bin/linux-x86-64 --> sh bin/linux-x86-64/sonar.sh start  
   - Login admin / admin 

4. # Jenkins Nexus Intergrations 
  - We do the intergration in both servers.
     # Nexus Server
  - Go to pom.xml 
   - Open Nexus Server --> Project Repository and copy both the snapshot and 
     releases url for both repositories 
   - Open pom.xml in the project directory in GitHub and add both repositories 
     from Nexus to Distribution Management.
   - Open pom.xml and search for <distributionmanagement> and edit the respective 
     urls copied from Nexus.  
   - Commit the changes

     # Jenkins Server 
   - setting.xml = jenkins server 
   - path: /var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/maven3.9.6/conf
     In docker container  
     
   - ls -->
     cd tools/ --> ls --> cd hudson.tasks.Maven_MavenInstallation/ --> ls --> 
     cd maven3.8.1/ ls --> ls conf/ --> vi conf/setting.xml
   - Search for Server Tag <severs> 
   - Before the closing tag for servers paste the following  
              <server>
                <id>nexus</id>
                <username>admin</username>
                <password>admin123</password>
            </server>
   - Save and exit.   

     # Nexus Server: 
   - To get the Nexus Server Information 
     vi /nexus/conf/setting.xml
            <server>
                <id>nexus</id>
                <username>admin</username>
                <password>admin123</password>
            </server> 
   - In Jenkins got to Project --> Configure --> Build --> Add Build Step --> 
     Invoke-top-level Maven Targets --> Goals (deploy) --> Build Now 

5. # Jenkins Tomcat Intergrations 
   cp *.war /var/lib/tomcat9/webapps
 - We do this intergration using a plugin call Deploy to Container  
 - In Jenkins go to Dashboard --> Manage Jenkins --> Manage Plugins --> 
   Available --> Search (Deploy to container)
 - Dashboard --> Project --> Configure --> Post-Build-Action --> Add Post-Build-Action --> 
   Deploy war or ear to container -->
   target / *war --> Add Container (Tomcat version) --> Paste Tomcat URL --> 
   Add Credentials --> Build Now   
 * Start Tomcat Server with the command starttomcat 
 * Check Tomcat Credentials
   - ls /opt --> ls /opt/tomcat9 --> ls /opt/tomcat9/conf --> 
     vi ls /opt/tomcat9/conf/tomcat-users.xml 
   - Check the users tag 
     <user username="vin" password="admin123" roles="manager-gui,admin-gui"/>
     <user username="vin" password="admin123" roles="manager-gui,admin-gui,manager-script"/> 

6. # Email Notification 
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
