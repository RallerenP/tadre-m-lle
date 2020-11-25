package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.models.Album;
import com.mchg.tadremoelle.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

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

}
