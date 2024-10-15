# Use a base image with Java
FROM maven:3.8.5-openjdk-17 AS builder


# Set the working directory
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml ./
COPY src ./src

# Run Maven clean package while skipping tests
RUN mvn clean package -DskipTests

# Build the application
RUN mvn clean package

# Use a new base image for the final build
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /RamiganiTech/target/RamiganiTech-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8095

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
