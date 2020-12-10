package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.dto.OpeningHoursDTO;
import com.mchg.tadremoelle.models.OpeningHours;
import com.mchg.tadremoelle.services.OpeningHoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/openinghours/")
public class OpeningHoursController {

    private OpeningHoursService openingHoursService;

    public OpeningHoursController(OpeningHoursService openingHoursService) {
        this.openingHoursService = openingHoursService;
    }

    @PostMapping("/")
    public OpeningHours add(@RequestBody OpeningHoursDTO dto) {
        return this.openingHoursService.add( dto );
    }
    @GetMapping("/")
    public List<OpeningHours> findAll() {
        return this.openingHoursService.findAll();
    }
}
