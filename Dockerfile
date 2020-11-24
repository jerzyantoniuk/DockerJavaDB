FROM java:8
LABEL maintainer="java_app"
COPY . /
WORKDIR /
RUN javac Main.java
CMD ["java","-classpath","mysql-connector-java.8.0.28.jar:.", "Main"]
CMD ["java", "Main"]
