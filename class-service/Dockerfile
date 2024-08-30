# Gunakan image resmi Java sebagai base image
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/class-service.jar class-service.jar

EXPOSE 8081

CMD ["java", "-jar", "class-service.jar"]
