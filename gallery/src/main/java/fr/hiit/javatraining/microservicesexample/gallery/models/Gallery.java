package fr.hiit.javatraining.microservicesexample.gallery.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
    private int id;
    private List<Object> images;
}
