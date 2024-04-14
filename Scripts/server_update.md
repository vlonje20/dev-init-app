Create the file:
```
server_update.sh
```
Copy and paste: 
```
#!/bin/bash
# Make script non interactive 
# Run as root for the first time 
export DEBIAN_FRONTEND=noninteractive

# Update and upgrade ubuntu
apt update
apt upgrade -y

# Install Jaja 
apt install default-jre -y
apt install openjdk-8-jdk -y

# Install Other tools 
apt install net-tools
apt install libuser -y  
snap install emacs --classic
```