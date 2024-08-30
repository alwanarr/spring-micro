FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/teacher-service.jar teacher-service.jar

EXPOSE 8083

CMD ["java", "-jar", "teacher-service.jar"]
