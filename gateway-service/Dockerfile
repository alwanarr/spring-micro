FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/gateway-service.jar gateway-service.jar

EXPOSE 9090

CMD ["java", "-jar", "gateway-service.jar"]
