# Gunakan image resmi Java sebagai base image
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/student-service.jar student-service.jar

EXPOSE 8080

CMD ["java", "-jar", "student-service.jar"]
