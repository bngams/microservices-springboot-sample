# FROM
# https://hub.docker.com/_/openjdk
# ( Docker Debian )
FROM openjdk:14-jdk-alpine
# Set the working directory to /app
WORKDIR /app
# Expose port
EXPOSE 9100

COPY . .

ARG ARG_EUREKA_HOST
ENV EUREKA_HOST=$ARG_EUREKA_HOST
ARG ARG_EUREKA_PORT
ENV EUREKA_PORT=$ARG_EUREKA_PORT

RUN echo $ARG_EUREKA_HOST
RUN echo $EUREKA_HOST

RUN sh ./mvnw package

CMD ["java", "-jar", "./target/auth-0.0.1-SNAPSHOT.jar"]
# build with arg
# docker build --build-arg=target/*.jar -t myapptag .
# ARG JAR_FILE
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","app.jar"]