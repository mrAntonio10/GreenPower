# Etapa de construcción
FROM adoptopenjdk/maven-openjdk8 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Etapa final
FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/upb-0.0.1-SNAPSHOT.jar /demo.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "demo.jar"]
