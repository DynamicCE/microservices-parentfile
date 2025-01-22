FROM openjdk:17 AS build
WORKDIR /app
COPY pom.xml .
COPY cards/ cards/
WORKDIR /app/cards
RUN chmod +x mvnw
RUN --mount=type=cache,target=/root/.m2 ./mvnw clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/cards/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"] 