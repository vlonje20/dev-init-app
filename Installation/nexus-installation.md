### Install Nexus as a container: 

Pull the image from DockerHub:
```
sudo docker pull sonatype/nexus3
```
Create the volume:
```
sudo docker volume create --name nexus-data
```
Run the container:
```
sudo docker run -d -p 8081:8081 --name nexus -v nexus-data:/nexus-data sonatype/nexus3
```

### Configure it on Browser: 

To open on browser:
If running locally on your PC:
```
localhost:8081
``` 
If running remotely like in AWS ec2-instance:
- IP:8081

Click Sigin: 
- Deafault username=admin 
- Default password= 

To get the default password: 
- On the terminal, run the command:
- Get into the nexus container  
```
sudo docker exec -it nexus /bin/bash 
``` 
Get the password:
``` 
cat /nexus-data/admin.password
```

Change your password accordingly <br>
Under 'Configure Anonymous Access' select 'Enable anonymous access'


### Nexus Jenkins Integration: 
Install Nexus Plugins:
- Dashboard ==> Manage Jenkins ==> Plugins 
- Available Plugins ==> Search 'Nexus Artifact Uploader'
- Select and install 