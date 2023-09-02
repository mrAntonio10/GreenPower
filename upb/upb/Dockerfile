# Etapa de construcción
FROM maven:3.6.3-jdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa final
FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/upb-0.0.1-SNAPSHOT.jar /demo.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "demo.jar"]
