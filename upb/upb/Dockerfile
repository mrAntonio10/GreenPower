# Etapa de construcción
FROM maven:3.6.3-jdk-8 AS build
COPY ../ ./
RUN mvn clean install

# Etapa final
FROM openjdk:8-jdk-alpine
COPY --from=build /target/upb-0.0.1-SNAPSHOT.jar /demo.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "demo.jar"]


##https://www.youtube.com/watch?v=9MR6VMZ9MBo&t=905s
#FROM node:12.22.12
##WORKDIR ./app
#COPY . .
#EXPOSE 8086
#
#CMD ["npm","run","start"]