package com.mchg.tadremoelle.repositories;

import com.mchg.tadremoelle.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
