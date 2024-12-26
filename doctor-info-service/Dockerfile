# Use Maven with JDK 17 for the build stage
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src/ src/

RUN mvn clean package -DskipTests

# Use OpenJDK 17 for the runtime stage
FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 80

CMD ["java", "-jar", "app.jar"]

#FROM openjdk:11-jre-slim
#COPY target/doctor-info-service-0.0.1-SNAPSHOT.jar /app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
