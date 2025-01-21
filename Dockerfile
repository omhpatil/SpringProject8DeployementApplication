FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["sh", "-c", "echo 'No app.jar provided'"]
EXPOSE 8080
