# Stage 1: Build the application
FROM gradle:8.9-jdk21 AS build
WORKDIR /app
COPY . .
RUN ls -l
RUN chmod +x gradlew && ./gradlew build -Dquarkus.package.type=uber-jar

# Stage 2: Create the final image
FROM openjdk:21
WORKDIR /app
COPY --from=build /app/build/*.jar /app/application.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/application.jar"]