FROM openjdk:17-jdk
# Definir ARG y ENV al inicio
ARG CONFIG_SERVER_URL
ENV CONFIG_SERVER_URL=${CONFIG_SERVER_URL}
RUN echo "Usando CONFIG_SERVER_URL: $CONFIG_SERVER_URL"
ARG GIT_URI
ENV GIT_URI=${GIT_URI}
RUN echo "Usando GIT_URI: $GIT_URI"
ARG EUREKA_HOST
ENV EUREKA_HOST=${EUREKA_HOST}
RUN echo "Usando EUREKA_HOST: $EUREKA_HOST"
ARG HOST_NAME
ENV HOST_NAME=${HOST_NAME}
RUN echo "Usando HOST_NAME: $HOST_NAME"
VOLUME /tmp
ARG JAR_FILE=target/koratosun-airlines-webfrontboot-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/app.jar"]