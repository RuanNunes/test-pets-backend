FROM maven:3.6.3-jdk-14 AS packager

RUN mkdir -p /test-pets

WORKDIR /test-pets

ADD ./pom.xml .
ADD ./docker-entrypoint.sh /
COPY settings.xml .

RUN mvn dependency:go-offline -s settings.xml
#RUN mvn clean install -X -f ./pom.xml

COPY ./ .


RUN mvn package -Dmaven.test.skip=true && \
    mv ./target/*.jar /run/test-pets-docker.jar

FROM openjdk:14

COPY --from=packager /run/test-pets-docker.jar /var/test-pets/test-pets-docker.jar
COPY --from=packager /docker-entrypoint.sh /docker-entrypoint.sh

RUN chmod +x /docker-entrypoint.sh

EXPOSE 8080

ENTRYPOINT [ "bash", "/docker-entrypoint.sh" ]
