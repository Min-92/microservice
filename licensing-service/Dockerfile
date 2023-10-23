FROM openjdk:17-slim
VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

##stage 1
#FROM openjdk:17-slim as build
#
#LABEL maintainer="minjae lee <0201.mj.lee@gmail.com>"
#
#ARG JAR_FILE
#
#COPY ${JAR_FILE} app.jar
#
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)
#
##stage 2
#FROM openjdk:17-slim
#
#VOLUME /tmp
#ARG DEPENDENCY=/target/dependency
#
#COPY --from=build $DEPENDENCY/BOOT_INF/lib /app/lib
#COPY --from=build $DEPENDENCY/META_INF /app/META_INF
#COPY --from=build $DEPENDENCY/BOOT_INF/classes /app
#
#
#ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.wangmin.licensingservice.LicensingServiceApplication"]
