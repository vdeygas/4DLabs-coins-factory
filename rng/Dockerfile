
FROM openjdk:8u181-jre-slim-stretch

# FROM debian:stretch
# RUN apt-get update && apt-get install openjdk-8-jre -y

COPY target/rng-0.0.1-SNAPSHOT.jar app.jar

ENV JAVA_OPTS=""

EXPOSE 80

CMD java $JAVA_OPTS -jar /app.jar