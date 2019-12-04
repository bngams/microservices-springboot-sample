package fr.hiit.javatraining.microservicesexample.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // @EnableDiscoveryClient
public class ImageMicroServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "image");
		SpringApplication.run(ImageMicroServiceApplication.class, args);
	}

}
