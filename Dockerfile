FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/app-ussers-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app-user.jar
ENTRYPOINT ["java", "-jar", "app-user.jar"]