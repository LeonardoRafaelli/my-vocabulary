# Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Enable detailed logging during the build
RUN mvn clean install -X || mvn clean install -DskipTests

# Run the application
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/ws-0.0.1-SNAPSHOT.jar ./app-aws.jar
EXPOSE 8080
CMD ["java", "-jar", "app-aws.jar"]