FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY build/libs/*.jar apisw-app.jar
ENTRYPOINT ["java","-jar","/apisw-app.jar"]
