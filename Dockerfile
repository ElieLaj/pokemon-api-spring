# Utiliser une image JDK 17 légère
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré dans l'image
COPY target/*.jar app.jar

# Exposer le port par défaut de Spring Boot
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]