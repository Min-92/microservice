FROM openjdk:17-slim

LABEL maintainer="minjae lee <0201.mj.lee@gmail.com>"

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=native", "-jar", "/app.jar"]
