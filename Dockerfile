From openjdk:8
copy ./target/springbootrestapiexp1-0.0.1-SNAPSHOT.jar springbootrestapiexp1-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","springbootrestapiexp1-0.0.1-SNAPSHOT.jar"]
