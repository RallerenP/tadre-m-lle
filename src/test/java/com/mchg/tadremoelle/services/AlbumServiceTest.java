package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.CreateAlbumDTO;
import com.mchg.tadremoelle.models.Album;
import com.mchg.tadremoelle.models.Image;
import com.mchg.tadremoelle.repositories.AlbumRepository;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlbumServiceTest {

    AlbumService albumService;
    @Mock
    AlbumRepository albumRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        albumService = new AlbumService(albumRepository);
    }

    @Test
    void findAll() {
    }

    @Test
    void add() {
        CreateAlbumDTO albumDTO = new CreateAlbumDTO();
        albumDTO.setAlbumName("TEST");

        Album album = albumService.transform(albumDTO);

        Album expected = new Album();
        expected.setAlbumName("TEST");
        expected.setImage(new ArrayList<>());
        expected.setId(0L);

        when(albumRepository.save(album)).thenReturn(expected);

        assertEquals(expected, albumService.add(albumDTO));

        verify(albumRepository, times(1)).save(album);

    }

    @Test
    void transform() {
        CreateAlbumDTO albumDTO = new CreateAlbumDTO();
        albumDTO.setAlbumName("TEST");

        Album actual = albumService.transform(albumDTO);

        Album expected = new Album();
        expected.setAlbumName("TEST");
        expected.setImage(new ArrayList<>());

        assertEquals(expected, actual);
    }
}