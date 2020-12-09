package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.PriceDTO;
import com.mchg.tadremoelle.models.Price;
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
        p.setId( (long) dto.getId() );
        p.setAdult(dto.getAdult());
        p.setGroupx(dto.getGroupx());
        p.setTeen(dto.getTeen());
        return this.priceRepository.save( p );

    }
    public List<Price> findAll() {
        return this.priceRepository.findAll();
    }
}
