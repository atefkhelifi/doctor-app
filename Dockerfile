# Use lightweight JDK base image
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy built JAR into the container
COPY target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "app.jar"]
