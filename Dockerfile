# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine

# Refer to Maven build -> finalName
ARG JAR_FILE=target/catalogo-produtos-productms.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/catalogo-produtos-productms.jar /opt/app/catalogo-produtos-productms.jar
COPY ${JAR_FILE} catalogo-produtos-productms.jar

# java -jar /opt/app/catalogo-produtos-productms.jar
ENTRYPOINT ["java","-jar","catalogo-produtos-productms.jar"]