# Use OpenJDK 11 as the base image
FROM openjdk:11

# Copy the backend JAR file from the target directory to the Docker image
COPY target/backend-1.0-SNAPSHOT.jar backend.jar

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "backend.jar"]

# Expose port 3000 to allow external access
EXPOSE 3000

