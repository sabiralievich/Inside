FROM openjdk:16-alpine3.13
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/Inside-backend.jar
ADD ${JAR_FILE} inside-backend.jar
ENTRYPOINT ["java","-jar","/inside-backend.jar"]

