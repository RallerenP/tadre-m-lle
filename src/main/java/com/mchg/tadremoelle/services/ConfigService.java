package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.models.Config;
import com.mchg.tadremoelle.repositories.ConfigRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
    private final ConfigRepository configRepository;

    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public String getNavbar() {
        return this.getValueByKey("navbar");
    }

    public void setNavbar(String value) {
        this.setValueByKey("navbar", value);
    }

    private String getValueByKey(String key) {
        return this.configRepository.getConfigByKey(key).getValue();
    }

    private void setValueByKey(String key, String value) {
        Config c = this.configRepository.getConfigByKey(key);
        if (c == null) {
            c = new Config();
            c.setKey(key);
        }

        c.setValue(value);
    }
}
