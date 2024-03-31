FROM openjdk:21-slim

WORKDIR /app
EXPOSE 8080

COPY ./build/libs/*.jar app.jar
ENV DB_PASS=pass

ENTRYPOINT ["java","-jar","/app/app.jar"]