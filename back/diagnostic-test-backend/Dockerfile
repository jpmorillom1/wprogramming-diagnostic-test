# ==========================
# BUILD
# ==========================
FROM eclipse-temurin:25-jdk AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# ==========================
# EXECUTION
# ==========================
FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
