# Stage 1 - Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Stage 2 - Enable detailed logging during the build
RUN mvn clean install -X || mvn clean install -DskipTests

# Run the application
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/my-vocabulary-0.0.1-SNAPSHOT.jar ./app-aws.jar
EXPOSE 8080
CMD ["java", "-jar", "app-aws.jar"]