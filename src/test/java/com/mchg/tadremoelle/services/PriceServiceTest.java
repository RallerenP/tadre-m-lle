package com.mchg.tadremoelle.services;
import com.mchg.tadremoelle.dto.PriceDTO;
import com.mchg.tadremoelle.models.Price;
import com.mchg.tadremoelle.repositories.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceService = new PriceService(priceRepository);
    }

    @Test
    void update() {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setId( 1 );
        //priceDTO.setTeen( "0" );
        //priceDTO.setGroupx( "15" );

        Price price = priceService.update(priceDTO);

        Price expected = new Price();
        expected.setId( (long) 1 );
        //expected.setTeen( "0" );
        //expected.setGroupx( "15" );

        when(priceRepository.save(price)).thenReturn(expected);

        assertEquals(expected, price);

        verify(priceRepository, times(1)).save(price);
    }
//    @Test
//    void transform() {
//        PriceDTO priceDTO = new PriceDTO();
//        priceDTO.setAdult( "35" );
//        priceDTO.setTeen( "0" );
//        priceDTO.setGroupx( "15" );
//
//        Price actual = priceService.update(priceDTO);
//
//        Price expected = new Price();
//        expected.setAdult( "35" );
//        expected.setTeen( "0" );
//        expected.setGroupx( "15" );
//
//        assertEquals(expected, actual);
//    }

    @Test
    void findAll() {
    }
}