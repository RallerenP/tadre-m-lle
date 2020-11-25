package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.models.Image;
import com.mchg.tadremoelle.repositories.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    public ImageService (ImageRepository ir) {
        this.imageRepository = ir;
    }

    public Iterable<Image> findAll() {
        return this.imageRepository.findAll();
    }


}
