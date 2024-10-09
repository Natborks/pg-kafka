FROM amazoncorretto:17-alpine-jdk
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# the JAR file path
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]