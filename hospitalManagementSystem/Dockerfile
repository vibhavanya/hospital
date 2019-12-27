FROM openjdk:8
RUN mkdir -p /var/liv/myapp
COPY target/hospitalManagementSystem-0.0.1-SNAPSHOT.jar    /var/lib/myapp

# Setup Working DIR
WORKDIR /var/lib/myapp

#EXPOSE
EXPOSE 8080

# Start the Bot Service
CMD ["java", "-jar", "hospitalManagementSystem-0.0.1-SNAPSHOT.jar"]


