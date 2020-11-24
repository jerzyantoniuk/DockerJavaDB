FROM java:latest
COPY . /home
WORKDIR /home
RUN javac Main.java
CMD ["java","-classpath","mysql-connector-java.8.0.28.jar:.", "Main"}
