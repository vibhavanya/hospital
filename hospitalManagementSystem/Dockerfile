FROM openjdk:8
RUN mkdir -p /var/lib/tomcat8
COPY target/hospitalManagementSystem-0.0.1-SNAPSHOT.jar    /var/lib/tomcat8

# Setup Working DIR
WORKDIR /var/lib/tomcat8

#EXPOSE
EXPOSE 8080

# Start the Bot Service
CMD ["java", "-jar", "hospitalManagementSystem-0.0.1-SNAPSHOT.jar"]


