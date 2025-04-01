FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

ARG JAR_FILE=build/libs/stock-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]