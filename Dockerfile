FROM --platform=linux/amd64 openjdk:17-jdk-alpine
RUN mkdir -p /opt/app
WORKDIR /opt/app
EXPOSE 8080
COPY build/libs/restdemo-0.0.1-SNAPSHOT.jar restdemo.jar
ENTRYPOINT ["sh", "-c", "java -jar restdemo.jar"]
