FROM openjdk:8-jdk-alpine
ADD target/Document-API-0.0.1-SNAPSHOT.jar document-api.jar
ARG MONGO_DATASOURCE_URL
EXPOSE 8082
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=${MONGO_DATASOURCE_URL}" ,"-jar", "document-api.jar"]