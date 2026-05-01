#Bygg jar-filen
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -f demo/pom.xml clean package -DskipTests

#Skapa slutgiltig image
#Test för att uppdatera github
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/demo/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]