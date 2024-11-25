# Étape 1 : Base image avec JDK
FROM eclipse-temurin:17-jdk-alpine

# Étape 2 : Définir le répertoire de travail
WORKDIR /app

# Étape 3 : Copier le fichier JAR dans l'image
COPY target/pokemon-api-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : Démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]