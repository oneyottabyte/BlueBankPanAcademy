FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/BlueBankPanAcademy-0.0.1-SNAPSHOT.jar bluebank.jar
ENTRYPOINT ["java", "-jar","/bluebank.jar"]