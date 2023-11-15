FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

EXPOSE 8080

FROM openjdk:17-jdk-slim

VOLUME /tmp
COPY --from=build /build/libs/gymapi-1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]