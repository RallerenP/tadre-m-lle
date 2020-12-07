package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.PriceDTO;
import com.mchg.tadremoelle.models.Price;
import com.mchg.tadremoelle.repositories.PageRepository;
import com.mchg.tadremoelle.repositories.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    public Price update(PriceDTO dto) {
        Price p = new Price();
        p.setAdult(dto.getAdult());
        p.setGroup(dto.getGroup());
        p.setTeen(dto.getTeen());
        return this.priceRepository.save( p );

    }
    public List<Price> findAll() {
        return this.priceRepository.findAll();
    }
}
