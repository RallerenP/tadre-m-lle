package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.CreatePageDTO;
import com.mchg.tadremoelle.dto.EditPageDTO;
import com.mchg.tadremoelle.models.Page;
import com.mchg.tadremoelle.models.Tag;
import com.mchg.tadremoelle.repositories.PageRepository;
import com.mchg.tadremoelle.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {

    private PageRepository pageRepository;
    private TagService tagService;

    public PageService(PageRepository pageRepository, TagService tagService) {
        this.pageRepository = pageRepository;
        this.tagService = tagService;
    }

    public Page add(CreatePageDTO dto) {
        Page p = new Page();
        p.setTitle(dto.getTitle());
        p.setContent(dto.getContent());
        p.setUrl(dto.getUrl());
        p.setTags( new ArrayList<Tag>() );
        p.setImage(dto.getImage());
        for (String tagName : dto.getTags()) {
            p.getTags().add( tagService.add( tagName ));
        }
        return this.pageRepository.save(p);
    }

    public List<Page> findAll() {
        return this.pageRepository.findAll();
    }

    public Page findByUrl(String url) {
        return this.pageRepository.findByUrl(url);
    }

    public void deleteById(long id){
        System.out.println("test2" + id);
        pageRepository.deleteById(id);
    }

    public Page updatePage(EditPageDTO dto) {
        Page p = this.pageRepository.findById(dto.getId());
        p.setContent(dto.getContent());
        p.setTitle(dto.getTitle());
        p.setUrl(dto.getUrl());
        p.setImage(dto.getImage());
        p.getTags().clear();

        for (String tagName : dto.getTags()) {
            p.getTags().add( tagService.add( tagName ));
        }

        pageRepository.save(p);

        return p;
    }
}
