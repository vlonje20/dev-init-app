# Team Running Notes: 

## Links: 
- To get our CHA 3tier Project link, see [CHA 3tier Project](https://docs.google.com/document/d/1U36YbHV87jT-AwL8ooKNgRQkZB2BmiV_OzCqpSlY-BY/edit)
- To get our canva project link, see [Canva Project](https://www.canva.com/design/DAF5sEif3jo/804scKmsxlXJ040DITFBpw/edit?utm_content=DAF5sEif3jo&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)
- To get AWS VPC Private CIDR Block link, see [CIDR Blocks from the Private IPv4 Address Ranges](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-cidr-blocks.html)
- To learn more about CIDR Block ranges, see [AN INTERACTIVE IP ADDRESS AND CIDR RANGE VISUALIZER](https://cidr.xyz/) 


## Scripting: 
#### How to run a script
- Create a new file and paste the script into it (e.g., userdata.sh). <br>
  nano userdata.sh 
- Make the script executable by running the following command in the terminal: <br>
  $ chmod +x userdata.sh.
- Run the script with the following commands: <br>
  $ ./userdata.sh OR <br> 
  $ sh userdata.sh

## Sample Scripts

=========================================
### server_update.sh (script)
#!/bin/bash

# Frontend noninteractive
export DEBIAN_FRONTEND=noninteractive

# update and upgrade my server
sudo apt update
sudo apt upgrade -y

# Java

sudo apt install default-jre -y
sudo apt install openjdk-11-jdk -y

# Other tools
sudo apt install net-tools
sudo apt install libuser -y

============================================
#### Hostname: 
- Temporally: 
  - You become root 
    $ sudo -i 
  - Change the hostname 
    $ hostname <yourHostname>
    $ exit 
    $ sudo -i  

- Permanently 
  - You become root 
    $ sudo -i 
  - Change the hostname
    $ hostnamectl set-hostname <hostname>
  - Next Edit the /etc/hosts file
    Delete the old name and input the new name  created.
    $ nano /etc/hosts
  
  - Reboot your virtual machine 
    $ reboot 

## Create Users: 
- useradd <userName>
- adduser <userName>
  - Become root 
    $ sudo -i
  - Create a new user 
    $ adduser newUser

- Disable password and add newUser to the Sudoers Group 
  echo "newUser ALL=(ALL) NOPASSWD:ALL" | sudo tee /etc/sudoers.d/newUser  |OR|
  echo "newUser ALL=(ALL) NOPASSWD:ALL" > /etc/sudoers.d/newUser

File Editors:
- touch 
- echo 
- vi 
- vim 
- nano 
- emacs 

ivo - pictures - my-pictures 
