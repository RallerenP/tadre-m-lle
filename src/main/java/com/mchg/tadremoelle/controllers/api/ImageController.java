package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.models.Image;
import com.mchg.tadremoelle.services.AlbumService;
import com.mchg.tadremoelle.services.ImageService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Value("${datapath}")
    private String dataPath;
    private ImageService imageService;
    private AlbumService albumService;

    public ImageController(ImageService is, AlbumService as) {
        this.imageService = is;
        this.albumService = as;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public Iterable<Image> findAll() {
        return this.imageService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody byte[] getImage(@PathVariable("id") Long id) throws IOException {
        Image i = this.imageService.getImageById(id);
        File fi = new File(i.getImageUrl());
        return Files.readAllBytes(fi.toPath());
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file")MultipartFile file, @RequestParam("albumsList") String albumName) {
        try {

            String randomString = RandomStringUtils.randomAlphanumeric(5);

            String contentType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            String pathname = dataPath + randomString + contentType;

            File transferFile = new File(pathname);
            file.transferTo(transferFile);

            this.imageService.save(pathname, albumName, albumService);

        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
        return "Success";
    }


}
