package fr.hiit.javatraining.microservicesexample.image.controllers.api;

import fr.hiit.javatraining.microservicesexample.image.models.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class ImageController {

    @GetMapping
    public String checkOnline() {
        return "Service Image ready and running";
    }

    @GetMapping("/images")
    public ResponseEntity<List<Image>> getImages() {
        List<Image> images = Arrays.asList(
                new Image(1, "Img1", "https://placeimg.com/640/480/any"),
                new Image(2, "Img2", "https://placeimg.com/640/480/any"),
                new Image(3, "Img3", "https://placeimg.com/640/480/any")
        );
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/imageslist")
    public List<Image> getImagesList() {
        List<Image> images = Arrays.asList(
                new Image(1, "Img1", "https://placeimg.com/640/480/any"),
                new Image(2, "Img2", "https://placeimg.com/640/480/any"),
                new Image(3, "Img3", "https://placeimg.com/640/480/any")
        );
        return images;
    }
}
