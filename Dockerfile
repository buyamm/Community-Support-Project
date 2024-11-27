# Stage 1: build
# Start with a Maven image that includes JDK 21
FROM maven:3.9.8-amazoncorretto-21 AS build

# Copy source code and pom.xml file to /app folder
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build source code with Maven
RUN mvn package -DskipTests

# Stage 2: create image
# Borrow another image to package our application and run it
# Start with Amazon Correcto JDK 21
FROM amazoncorretto:21.0.4

# Set working folder to App and copy complied file from above step
# rename to app.jar
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]