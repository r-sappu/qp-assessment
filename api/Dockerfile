FROM openjdk:17-jdk-alpine
EXPOSE 9080
COPY target/grocery-application.jar grocery-application.jar
ENTRYPOINT ["java","-jar","/grocery-application.jar"]