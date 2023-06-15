FROM openjdk:17-alpine3.14
ADD target/psql.jar psql.jar
ADD src/main/resources/ .
EXPOSE 8080
RUN mkdir documents
ENTRYPOINT ["java","-jar","psql.jar"]
