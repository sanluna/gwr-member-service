FROM openjdk:8-jdk-alpine
MAINTAINER Alexander_Lundberg_Santos

RUN apk add --no-cache bash
ADD ./target/*.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/app.jar"]
EXPOSE 18100