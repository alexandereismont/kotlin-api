#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY ./frontend /home/app/frontend
COPY ./target /home/app/target
#RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM public.ecr.aws/j8l5v4j6/openjdk-11-jre-slim:latest
COPY --from=build /home/app/target/kotlin-api-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]