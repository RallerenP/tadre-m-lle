package com.mchg.tadremoelle.repositories;

import com.mchg.tadremoelle.models.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    Config getConfigByKey(String key);
}
