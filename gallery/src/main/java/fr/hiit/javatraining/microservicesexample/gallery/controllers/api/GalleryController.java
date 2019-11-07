package fr.hiit.javatraining.microservicesexample.gallery.controllers.api;

import fr.hiit.javatraining.microservicesexample.gallery.models.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class GalleryController {

    // get the instance from RestTemplateConfig Bean
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String checkOnline() {
        return "Gallery service is up and running";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGallery(@PathVariable final int id) {
        // get list of images
        List<Object> images = restTemplate.getForObject("http://image-service/images", List.class);

        // create and return Gallery
        Gallery g = new Gallery(id, images);

        return new ResponseEntity<>(g, HttpStatus.OK);

    }
}
