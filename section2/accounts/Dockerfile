FROM openjdk:17 AS build
WORKDIR /app
COPY pom.xml .
COPY accounts/ accounts/
WORKDIR /app/accounts
RUN chmod +x mvnw
RUN --mount=type=cache,target=/root/.m2 ./mvnw clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/accounts/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]