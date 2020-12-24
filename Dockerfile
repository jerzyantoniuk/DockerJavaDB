FROM java:8
LABEL maintainer="java_app"
COPY . /
WORKDIR /
RUN javac App.java
CMD ["java","-classpath","mysql-connector-java.8.0.28.jar:.", "App"]
CMD ["java", "App"]
