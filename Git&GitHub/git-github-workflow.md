### GIT WORKFLOW: 
GitHub:
- Create your repository and give it a unique name 
- Do not add a READMe file (This will be added in git) <br>

Pushing to a new Repository: <br>
(By create a new repository on the command line)
Intitialize Local Repo:
```
git init
```
Add a README.md file:
```
git add README.md
```
Commit the file:
```
git commit -m "first commit"
```
Rename the current branch to 'main':
```
git branch -M main
```
Create an aliasName:
```
git remote add origin url 
```
Push your code to gitHub:
```
git push -u origin main
```
##
Pushing an existing repository from the command line:  
Create an aliasName:
```
git remote add origin url 
```
Rename the current branch to 'main':
```
git branch -M main
```
Push your code to gitHub:
```
git push -u origin main
```
##

Git | Local Repository:
Create your repository Directory and cd to it:  
```
mkdir myDirectory && cd myDirectory 
```
Initialized your Directory: 
```
git init 
```
##
### Git ENVIRONMENT: 
Working Environment: <br> 
To add all the files in the current working Directory: 
```
git add . 
```
To add just one file:
```
git add fileName 
```
To add multiple files but not all in the current working directory:   
```
git add file1 file4 file15
``` 
##
Staging Environment: 
```
git commit -m "commit message"
```
##
Production Environment: <br> 
AliasName <br> 
To create your AliasName:  
```
git remote add aliasName url
``` 
To see your aliasName:
```
git remote -v
```  
To delete aliasName:
```
git remote remove aliasName
```
##

Branching: <br>
To create a branch:  
```
git branch branchName
```
To swtch to another branch:
```
git checkout branchName
``` 
To create and branch and switched to it: 
```
git checkout -b branchName
```
To delete a branch: 
```
git branch -d <branchName>
``` 
To merge branches: 
```
git merge branchName
``` 
If merge fails: (do manual merging by opening the file and fit the codes)
## 
Tags: <br>
After doing your commit, create a tag: <br>
(git tag -a tagName -m "tag message")
```
git tag -a v1.0 -m "Release version 1.0"
``` 
Push all tags:
```
git push --tags
```
Push tags to a specific branch:
```
git push origin v1.0:bugfix
``` 
##

Other Commands in Production Environment: <br>
To push to remote repository without tagging:
```
git push aliasName branchName
``` 
To pull from remote repository: 
```
git pull aliasName
``` 
##
