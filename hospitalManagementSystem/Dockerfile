FROM openjdk:8
RUN mkdir -p /usr/local/tomcat
COPY target/hospitalManagementSystem-0.0.1-SNAPSHOT.jar    /usr/local/tomcat

# Setup Working DIR
WORKDIR /usr/local/tomcat

#EXPOSE
EXPOSE 8080

# Start the Bot Service
CMD ["java", "-jar", "hospitalManagementSystem-0.0.1-SNAPSHOT.jar"]


