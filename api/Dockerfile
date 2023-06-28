FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/*.jar

COPY ./src/main/resources/static/game/json/*.json ./game/json/

COPY ${JAR_FILE} api.jar

ENTRYPOINT ["java","-jar","api.jar"]