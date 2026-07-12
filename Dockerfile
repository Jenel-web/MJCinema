# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application within memory limits
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Enforce Render's 512MB RAM constraints safely
ENV JAVA_TOOL_OPTIONS="-XX:+UseSerialGC -Xss256k -Xmx300m"

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]