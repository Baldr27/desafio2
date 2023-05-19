FROM openjdk:17

VOLUME /tmp

EXPOSE 3001

COPY target/apicar-0.0.1-SNAPSHOT.jar apicar-container.jar

CMD ["java", "-jar", "apicar-container.jar"]
