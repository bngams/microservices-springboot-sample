package fr.hiit.javatraining.microservicesexample.gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GalleryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalleryMicroServiceApplication.class, args);
	}

}
