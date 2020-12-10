package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.OpeningHoursDTO;
import com.mchg.tadremoelle.models.OpeningHours;
import com.mchg.tadremoelle.repositories.OpeningHoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpeningHoursService {

    private OpeningHoursRepository openingHoursRepository;

    public OpeningHoursService(OpeningHoursRepository openingHoursRepository) {
        this.openingHoursRepository = openingHoursRepository;
    }

    public OpeningHours add(OpeningHoursDTO dto) {
        OpeningHours oh = new OpeningHours();
        oh.setStart(dto.getStart());
        oh.setEnd(dto.getEnd());
        oh.setText(dto.getText());
        oh.setTime(dto.getTime());
        return this.openingHoursRepository.save( oh );

    }
    public List<OpeningHours> findAll() {
        return this.openingHoursRepository.findAll();
    }
}
