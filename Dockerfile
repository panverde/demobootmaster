FROM openjdk:8-jdk-alpine
LABEL maintainer="joaquin"
WORKDIR /workspace
ADD target/demobo*.jar app.jar

ENV host="postgres_server"
ENV port="5432"
ENV database="joaquin"
ENV username="postgres"
ENV password="admin"
ENV url_apistudent="apistudent"
ENV port_apistudent="8080"

ENV DOCKERIZE_VERSION v0.6.1
#Podemos descargar dockerize o copiarlo desde un directorio
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /workspace/app.jar
EXPOSE 8085