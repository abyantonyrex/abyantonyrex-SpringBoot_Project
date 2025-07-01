# Stage 1: Build the application
FROM gradle:8.5.0-jdk17 AS builder
WORKDIR /app

# Copy only necessary files for Gradle to cache dependencies
COPY build.gradle settings.gradle ./
COPY src ./src

# Run build (skip tests)
RUN gradle build -x test

# Stage 2: Create a smaller image to run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
