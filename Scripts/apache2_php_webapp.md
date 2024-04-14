Create the file:
```
apache2_php_webapp.sh
```
Copy and paste: 
```
#!/bin/bash

# Make script non interactive: 
export DEBIAN_FRONTEND=noninteractive

# Update and upgrade the server:
sudo apt update
sudo apt upgrade -y

# Install Apache2:
sudo apt install apache2 -y

# Enable and Start Apache2 Service:
sudo systemctl enable apache2
sudo systemctl start apache2

# Install PHP:
sudo apt install php libapache2-mod-php -y

# Then, restart Apache to apply the changes:
sudo systemctl restart apache2

# Delete index.html file:
sudo rm -rf /var/www/html/index.html

# Create a Script to Display IP Address
# Create a file to put the script (usually /var/www/html):
# sudo touch /var/www/html/index.php

# Place your your codes inside the index.php file you just created:
echo "<h1>
<?php
echo 'VIN | Welcome to my WORLD | vin-app-v1: ' . $_SERVER['SERVER_ADDR'];
?>
</h1>

<img src="https://vin-project.s3.amazonaws.com/project-images/mr+dramacydal.jpeg" 
alt="Mr Dramacydal">" | sudo tee -a /var/www/html/index.php > /dev/null

# <img src="insert pic URL">" | sudo tee -a /var/www/html/index.php > /dev/null
```
