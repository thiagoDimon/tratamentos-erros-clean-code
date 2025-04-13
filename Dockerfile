FROM openjdk:21
WORKDIR /app
COPY ./src ./src
RUN mkdir -p bin
RUN javac -d bin src/main/java/org/example/*.java
ENTRYPOINT ["java", "-cp", "bin:src/main/resources", "org.example.Main"]