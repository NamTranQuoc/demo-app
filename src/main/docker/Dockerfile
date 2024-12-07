# Stage 1: Build the application
FROM gradle:8.9-jdk21 AS build
WORKDIR /app
COPY . .
RUN ./gradlew build -Dquarkus.package.type=fast-jar

# Stage 2: Create the final image
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=build /app/build/quarkus-app/lib/ /app/lib/
COPY --from=build /app/build/quarkus-app/*.jar /app/
COPY --from=build /app/build/quarkus-app/app/ /app/app/
COPY --from=build /app/build/quarkus-app/quarkus-run.jar /app/quarkus-run.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/quarkus-run.jar"]