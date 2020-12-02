package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.CreateAlbumDTO;
import com.mchg.tadremoelle.models.Album;
import com.mchg.tadremoelle.repositories.AlbumRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository ar) {
        this.albumRepository = ar;
    }

    public List<Album> findAll() {
        return this.albumRepository.findAll();
    }

    public Album add(CreateAlbumDTO albumDTO) {
        if (findByName(albumDTO.getAlbumName()) == null) {
            return this.albumRepository.save(transform(albumDTO));
        }
        return null;
    }

    public Album transform(CreateAlbumDTO albumDTO) {
        Album album = new Album();
        album.setAlbumName(albumDTO.getAlbumName());
        album.setImage(new ArrayList<>());
        return album;
    }

    public Album findByName(String name) {
        return albumRepository.findByAlbumName(name);
    }

}
