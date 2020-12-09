package com.mchg.tadremoelle.repositories;

import com.mchg.tadremoelle.models.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, String> {
    Config getConfigByKey(String key);
}
