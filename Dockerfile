FROM eclipse-temurin:17-jre

ADD target/spring-otlp-tracing-profiling-*-SNAPSHOT.jar /app.jar

ENTRYPOINT java -jar app.jar
