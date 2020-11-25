FROM java:8
LABEL maintainer="java_app"
COPY . /
WORKDIR /
RUN javac DockerJavaDB.java
CMD ["java","-classpath","mysql-connector-java.8.0.28.jar:.", "DockerJavaDB"]
CMD ["java", "DockerJavaDB"]
