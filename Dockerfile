FROM openjdk:8
EXPOSE 8089
ADD target/gestion-station-ski-1.2-SNAPSHOT.jar gestion-station-ski-1.2-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/docker-spring-boot.jar"]