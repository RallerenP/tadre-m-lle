package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.annotations.AuthGuard;
import com.mchg.tadremoelle.dto.CreateAlbumDTO;
import com.mchg.tadremoelle.models.Album;
import com.mchg.tadremoelle.services.AlbumService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    public List<Album> findAll() {
        return this.albumService.findAll();
    }

    @AuthGuard
    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public Album add(@RequestBody CreateAlbumDTO albumDTO, HttpServletResponse response) {
        Album result = albumService.add(albumDTO);
        if (result == null) {
            response.setStatus(409);
            return null;
        }
        return result;
    }

}
