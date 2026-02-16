# Use official OpenJDK 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src ./src

# Package the application
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Copy the built jar
COPY target/Employees-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
