FROM openjdk:8-alpine

EXPOSE 8080

COPY target/Backend-1.0-SNAPSHOT.jar /opt/application.jar

CMD ["java", "-jar", "/opt/application.jar"]