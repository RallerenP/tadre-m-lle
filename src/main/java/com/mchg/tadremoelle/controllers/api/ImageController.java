package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.models.Image;
import com.mchg.tadremoelle.services.ImageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService is) {
        this.imageService = is;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public Iterable<Image> findAll() {
        System.out.println(this.imageService.findAll());
        return this.imageService.findAll();
    }


}
