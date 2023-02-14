FROM openjdk:19

COPY target/KTT-0.0.1-SNAPSHOT.jar KTT-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "KTT-0.0.1-SNAPSHOT.jar"]