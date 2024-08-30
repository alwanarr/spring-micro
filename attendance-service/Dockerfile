FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/attendance-service.jar attendance-service.jar

EXPOSE 8082

CMD ["java", "-jar", "attendance-service.jar"]
