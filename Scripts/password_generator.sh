#!/bin/bash
# This is a script to generate a random password
# Ask for the password length
echo -n "Enter the password length: "
read length

# Define the character set
chars="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*"

# Loop through the length and choose a random character from the set
password=""
for ((i = 0; i < length; i++))
do
  index=$((RANDOM % ${#chars}))
  password="${password}${chars:index:1}"
done

# Display the generated password
echo "Your password is: $password"