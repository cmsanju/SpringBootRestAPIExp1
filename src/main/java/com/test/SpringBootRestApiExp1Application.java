package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class SpringBootRestApiExp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiExp1Application.class, args);
	}

}

/*

From openjdk:8
copy ./target/springbootrestapiexp1-0.0.1-SNAPSHOT.jar springbootrestapiexp1-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","springbootrestapiexp1-0.0.1-SNAPSHOT.jar"]


1 after gving the path

docker image build -t oct-batch . 

2 start container

docker container run --name octb -p 8080:8080 -d oct-batch

3 for logs
 docker logs octb

*/