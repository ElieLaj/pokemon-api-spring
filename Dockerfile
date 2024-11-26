FROM eclipse-temurin:17-jdk-jammy as build

WORKDIR /app

COPY target/pokemon-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]