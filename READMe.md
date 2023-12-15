CICD Project with Jenkins:  
==========================

Install applications needed: 
- Install git: 
  https://git-scm.com/downloads 

  - Configure git: 
    - git config --global user.name "gitHub-User-Name"
    - git config --global user.email "gitHubEmail"



- Create an account with gitHub: 
  https://github.com/ 



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