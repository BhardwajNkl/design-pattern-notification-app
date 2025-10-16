# Start from a JDK base image
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy project files to image
COPY . .

# Run when container starts
ENTRYPOINT ["java", "-jar", "JAR/notification_app.jar"]
