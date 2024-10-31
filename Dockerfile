FROM eclipse-temurin:latest
ADD target/job_app.jar job_app.jar
ENTRYPOINT [ "java", "-jar", "/job_app.jar" ]