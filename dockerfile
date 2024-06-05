# Build the application
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install


# Run the application
FROM openjdk:18
WORKDIR /app
COPY --from=build /app/target/ws-0.0.1-SNAPSHOT.jar ./app-aws.jar
EXPOSE 8080
CMD ["java", "-jar", "app-aws.jar"]