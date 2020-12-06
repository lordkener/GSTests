FROM node as frontend
WORKDIR /frontend
COPY frontend/phonecatalog .
RUN npm ci
RUN npm run-script build

FROM maven:3.6.3-jdk-11 as backend
WORKDIR /backend
COPY backend .
RUN mkdir -p src/main/resources/static
COPY --from=frontend /frontend/build src/main/resources/static
RUN mvn clean verify

FROM openjdk:14-jdk-alpine
COPY --from=backend /backend/target/phonecatalog-0.0.1-SNAPSHOT.jar ./app.jar
COPY backend/src/main/resources/static src/main/resources/static
EXPOSE 8443 3306
RUN adduser -D user
USER user
CMD ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar app.jar"]