package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.CreateTagDTO;
import com.mchg.tadremoelle.models.Tag;
import com.mchg.tadremoelle.repositories.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag add(CreateTagDTO dto) {
        if (this.findTagByName( dto.getName() ) != null) {
            return this.findTagByName( dto.getName() );
        }
        Tag t = new Tag();
        t.setName( dto.getName() );
        return this.tagRepository.save( t );
    }

    public Tag add(String tagName) {
        CreateTagDTO dto = new CreateTagDTO();
        dto.setName( tagName );
        return this.add( dto );
    }
    public Tag findTagByName(String name) {
        return this.tagRepository.findByName( name );

    }
}
