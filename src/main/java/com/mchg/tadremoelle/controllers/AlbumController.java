package com.mchg.tadremoelle.controllers;

import com.mchg.tadremoelle.models.Album;
import com.mchg.tadremoelle.services.AlbumService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private AlbumService albumService;

    public AlbumController(AlbumService as) {
        this.albumService = as;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public List<Album> readAll() {
        return this.albumService.findAll();
    }

}
