# Use an official Tomcat runtime as a parent image
FROM tomcat:9.0.54-jdk8-openjdk-slim-buster

# Set the working directory to /usr/local/tomcat/webapps
WORKDIR /var/lib/tomcat9/webapps

# Copy the war file to the container at /usr/local/tomcat/webapps
COPY target/*war /var/lib/tomcat/webapps

# Expose port 8080 to the world outside this container
EXPOSE 8080

# Start Tomcat when the container launches
CMD ["catalina.sh", "run"]
