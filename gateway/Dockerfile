# FROM
# https://hub.docker.com/_/openjdk
# ( Docker Debian )
FROM openjdk:14-jdk-alpine
# Set the working directory to /app
WORKDIR /app
# Expose port
EXPOSE 8762
# docker build --build-arg=target/*.jar -t myapptag .
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]