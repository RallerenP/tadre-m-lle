package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.annotations.AuthGuard;
import com.mchg.tadremoelle.dto.PriceDTO;
import com.mchg.tadremoelle.models.Price;
import com.mchg.tadremoelle.services.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    private PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @AuthGuard
    @PutMapping("/{id}")
    public Price update(@RequestBody PriceDTO dto) {
        return this.priceService.update(dto);
    }

    @GetMapping("/")
    public List<Price> findAll() {

        return this.priceService.findAll();
    }

}
