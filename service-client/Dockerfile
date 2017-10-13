FROM openjdk:8-jdk-alpine
COPY target/service-client-0.2.jar /service-client-0.2.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -Djava.security.egd=file:/dev/./urandom -jar /service-client-0.2.jar" ]