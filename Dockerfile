FROM maven:3.8.1-openjdk-17-slim as maven
WORKDIR /app
COPY ./ArqHexagonalModular/pom.xml /app/
COPY ./ArqHexagonalModular/application/pom.xml /app/application/
COPY ./ArqHexagonalModular/application/src /app/application/src
COPY ./ArqHexagonalModular/boot/pom.xml /app/boot/
COPY ./ArqHexagonalModular/boot/src /app/boot/src
COPY ./ArqHexagonalModular/domain/pom.xml /app/domain/
COPY ./ArqHexagonalModular/domain/src /app/domain/src
COPY ./ArqHexagonalModular/infrastructure/pom.xml /app/infrastructure/
COPY ./ArqHexagonalModular/infrastructure/src /app/infrastructure/src
RUN mvn clean package

FROM openjdk:17.0.1-jdk-slim
ENV TZ='Europe/Paris'
WORKDIR /app
COPY --from=maven /app/target/*.jar /app/
EXPOSE 8081
CMD find *.jar -exec java -jar $JAVA_OPTS -XshowSettings:vm {} ';'
