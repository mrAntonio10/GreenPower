#
# BUILD
#
FROM maven:3.6.2-openjdk-8 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package

#
# RUN
#
FROM openjdk:8-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]