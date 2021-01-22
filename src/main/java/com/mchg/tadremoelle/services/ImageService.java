package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.models.Album;
import com.mchg.tadremoelle.models.Image;
import com.mchg.tadremoelle.repositories.AlbumRepository;
import com.mchg.tadremoelle.repositories.ImageRepository;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    public ImageService (ImageRepository ir) {
        this.imageRepository = ir;
    }

    public Iterable<Image> findAll() {
        return this.imageRepository.findAll();
    }

    public boolean save(String imageUrl, String albumName, AlbumService as) {
        Image image = new Image();
        image.setImageUrl(imageUrl);

        Album album = as.findByName(albumName);
        image.setAlbum(album);

        imageRepository.save(image);
        as.addToExistingAlbum(image, albumName);

        return true;
    }

    public Image getImageById(Long id) {
        return this.imageRepository.findImageById(id);
    }

    public void deleteImage(Long id) {
        Image image = getImageById(id);
        image.getAlbum().getImage().remove(image);
        imageRepository.delete(image);
    }


}
