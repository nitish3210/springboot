# Use an official OpenJDK runtime as a parent image
FROM openjdk:8
# Make port 8080 available to the world outside this container
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} restful.jar
# Run spring-mysql-demo.jar when the container launches
ENTRYPOINT ["java", "-jar", "/restful.jar"]