Create the file:
```
add_user.sh
```
Copy and paste: 
```
#!/bin/bash
# This is a script to create a user in Ubuntu
# Ask for the username and password
echo -n "Enter the username: "
read username
echo -n "Enter the password: "
read -s password

# Create the user with a home directory and bash as the default shell
useradd -m -d /home/$username -s /bin/bash $username

# Set the password for the user
echo "$password" | passwd --stdin $username

# Add the user to the sudo group
usermod -aG sudo $username

# Disable the sudo password prompt for the user
echo "$username ALL=(ALL) NOPASSWD:ALL" | sudo EDITOR='tee -a' visudo

# Display a confirmation message
echo "User $username created successfully."
```