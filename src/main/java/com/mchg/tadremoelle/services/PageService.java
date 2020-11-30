package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.CreatePageDTO;
import com.mchg.tadremoelle.models.Page;
import com.mchg.tadremoelle.repositories.PageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    private PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public Page add(CreatePageDTO dto) {
        Page p = new Page();
        p.setTitle(dto.getTitle());
        p.setContent(dto.getContent());
        p.setUrl(dto.getUrl());
        return this.pageRepository.save(p);
    }

    public List<Page> findAll() {
        return this.pageRepository.findAll();
    }

    public Page findByUrl(String url) {
        return this.pageRepository.findByUrl(url);
    }
}
