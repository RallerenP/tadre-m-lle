package com.mchg.tadremoelle.repositories;

import com.mchg.tadremoelle.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
