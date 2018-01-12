#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD target/swagger-0.0.1-SNAPSHOT.jar target/app.jar target/app.jar
#EXPOSE 8080
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]

FROM java:8
VOLUME /tmp
# ARG JAR_FILE
ADD target/swagger-back-0.0.1-SNAPSHOT.jar target/app.jar
EXPOSE 8090
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]