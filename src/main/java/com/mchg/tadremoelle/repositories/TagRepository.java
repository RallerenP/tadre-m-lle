package com.mchg.tadremoelle.repositories;

import com.mchg.tadremoelle.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);
}
