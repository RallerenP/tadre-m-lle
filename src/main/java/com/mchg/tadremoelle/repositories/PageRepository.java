package com.mchg.tadremoelle.repositories;

import com.mchg.tadremoelle.models.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, Long> {
    Page findByUrl(String url);
    Page findById(long id);
}
