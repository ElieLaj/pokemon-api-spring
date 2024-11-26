FROM maven:3.9.2-eclipse-temurin-17-alpine as builder

COPY ./src src/
COPY ./pom.xml pom.xml

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY target/pokemon-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
CMD ["java","-jar","app.jar"]