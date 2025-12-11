FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# 2. NUEVO: Copiamos el docker-compose.yml dentro de la imagen
# Esto es vital para tu estrategia de despliegue actual.
# El archivo quedará en: /app/docker-compose.yml
COPY docker-compose.yml /app/docker-compose.yml

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]