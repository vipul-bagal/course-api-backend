# Use a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built application jar to the container
COPY target/course-management-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
