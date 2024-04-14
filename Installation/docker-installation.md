### Docker Installation: 
Install Java as a prerequisite:
``` 
sudo apt install default-jre -y
```
Update your server: 
```
sudo apt update
```
Install Docker:   
```
sudo apt install docker.io -y
```
```
sudo chmod 666 /var/run/docker.sock
```
```
sudo systemctl enable docker 
```
```
sudo systemctl start docker
```
```
sudo systemctl status docker
```

Add yourUser to the docker group:
``` 
sudo usermod -aG docker yourUser
```