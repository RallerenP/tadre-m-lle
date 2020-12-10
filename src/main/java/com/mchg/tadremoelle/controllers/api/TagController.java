package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.dto.CreateTagDTO;
import com.mchg.tadremoelle.models.Tag;
import com.mchg.tadremoelle.services.TagService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/")
    public Tag add(@RequestBody CreateTagDTO dto) {
        return this.tagService.add(dto);
    }
}
