package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.services.ConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/config")
public class NavbarController {
    private final ConfigService configService;

    public NavbarController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/navbar")
    public String getNavbarLinks() {
        return this.configService.getNavbar();
    }

    @PostMapping("/navbar")
    public String setNavbarLinks(HttpServletRequest request) {
//        return this.configService.setNavbar();
        return null;
    }
}
