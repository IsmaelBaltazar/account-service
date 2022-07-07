FROM openjdk:8-jdk-alpine
COPY "./target/account-service-0.0.1.jar" "app.jar"
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]