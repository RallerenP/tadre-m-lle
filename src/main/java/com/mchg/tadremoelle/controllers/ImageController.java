package com.mchg.tadremoelle.controllers;

import com.mchg.tadremoelle.models.Image;
import com.mchg.tadremoelle.services.ImageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService is) {
        this.imageService = is;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/readAll")
    public Iterable<Image> readAll() {
        System.out.println(this.imageService.findAll());
        return this.imageService.findAll();
    }


}
