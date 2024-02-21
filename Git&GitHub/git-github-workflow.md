# Git and GitHub:

GIT WORKFLOW: 
============= 

GitHub: 
======= 
- Create your repository and give it a unique name 
- Do not add a READMe file (This will be added in git)

Pushing to a new Repository: (By create a new repository on the command line)
===========================
  $ git init
  $ git add README.md
  $ git commit -m "first commit"
  $ git branch -M main
  $ git remote add origin url 
  $ git push -u origin main


Pushing an existing repository from the command line: 
===================================================== 
  $ git remote add origin url 
  $ git branch -M main
  $ git push -u origin main


Git: 
====
- Create your repository Directory and cd to it  
  $ mkdir myDirectory && cd myDirectory 

- Initialized your Directory 
  $ git init 


Git ENVIRONMENT: 
================ 

# Working Environment: 
- To add all the files in the current working Directory 
  $ git add . 

- To add just one file  
  $ git add fileName 

- To add multiple files but not all in the current working directory   
  $ git add file1 file4 file15 


# Staging Environment: 
- git commit -m "commit message"


# Production Environment: 
- AliasName 
  - To create your AliasName  
     $ git remote add aliasName url 
     $ git remote -v = To see your aliasName 
     $ git remote remove aliasName = To delete aliasName 


# Branching: 
  - To create a branch:  
     $ git branch branchName
     $ git checkout branchName 

     - You can combine both commands: 
     $ git checkout -b branchName

  - To delete a branch: 
     $ git branch -d <branchName> 

  - To merge branches: 
     $ git merge branchName 
  - If merge fails: (do manual merging by opening the file and fit the codes)


# Tags:
  - After doing your commit, create a tag: 
     $ git tag -a v1.0 -m "Release version 1.0" (git tag -a tagName -m "tag message")
     $ git push --tags = Push all tags 
     $ git push origin v1.0:bugfix = push tags to a specific branch  


# Other Commands in Production Environment: 
     $ git push aliasName branchName = To push to remote repository without tagging 
     $ git pull aliasName = To pull from remote repository  





