FROM
FROM openjdk:8-jdk-slim

RUN mkdir -p /app

COPY target/upb-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/upb-0.0.1-SNAPSHOT.jar"]