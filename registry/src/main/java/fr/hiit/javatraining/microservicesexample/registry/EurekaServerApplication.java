package fr.hiit.javatraining.microservicesexample.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "registry");
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
