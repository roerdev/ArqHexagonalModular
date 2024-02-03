FROM maven:3.8.1-openjdk-17-slim as maven
WORKDIR /app
COPY . /app
RUN mvn clean package

FROM openjdk:17.0.1-jdk-slim
ENV TZ='Europe/Paris'
WORKDIR /app
COPY --from=maven /app/target/*.jar /app/
EXPOSE 8081
CMD find *.jar -exec java -jar $JAVA_OPTS -XshowSettings:vm {} ';'


