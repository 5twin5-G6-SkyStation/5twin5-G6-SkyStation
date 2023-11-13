FROM openjdk:8
EXPOSE 8089
ADD target/gestion-station-ski-0.0.1-SNAPSHOT.jar skitest.jar
ENTRYPOINT ["java", "-jar", "/skitest.jar"]

