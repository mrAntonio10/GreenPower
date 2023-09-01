FROM adoptopenjdk/maven-openjdk8 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-alpine
COPY --from=build '/target/upb-0.0.1-SNAPSHOT.jar' 'demo.jar'
EXPOSE 8086
ENTRYPOINT ["java","-jar","demo.jar"]