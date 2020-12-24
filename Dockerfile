FROM java:latest
LABEL maintainer="java_app"
COPY . /
WORKDIR /
RUN javac DockerConnectMySQL.java
CMD ["java","-classpath","mysql-connector-java.8.0.28.jar:.", "DockerConnectMySQL"]

