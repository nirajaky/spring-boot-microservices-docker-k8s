FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} configserver.jar

ENTRYPOINT ["java", "-jar", "/orderservice.jar"]

EXPOSE 9296