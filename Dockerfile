FROM --platform=linux/x86_64 openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/matches-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]