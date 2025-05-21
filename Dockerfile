# Etapa 1: build do projeto
FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: rodar o JAR
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]