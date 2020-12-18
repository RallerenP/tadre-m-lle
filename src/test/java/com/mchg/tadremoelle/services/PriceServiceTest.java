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
    void findAll() {
    }
}