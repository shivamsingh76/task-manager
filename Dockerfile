# Step 1: Use an official Java runtime as the base image
FROM eclipse-temurin:21-jdk
# Step 2: Set the working directory inside the container
WORKDIR /app
# Step 3: Copy the JAR file from the target folder to the working directory
COPY target/task-manager-0.0.1-SNAPSHOT.jar task-manager-0.0.1-SNAPSHOT.jar
# Step 4: Expose the port your application will run on
EXPOSE 8080
# Step 5: Specify the command to run the application
ENTRYPOINT ["java", "-jar", "task-manager-0.0.1-SNAPSHOT.jar"]