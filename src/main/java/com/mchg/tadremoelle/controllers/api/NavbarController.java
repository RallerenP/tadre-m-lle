package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.annotations.AuthGuard;
import com.mchg.tadremoelle.annotations.GetUser;
import com.mchg.tadremoelle.dto.AddNavbarDTO;
import com.mchg.tadremoelle.models.User;
import com.mchg.tadremoelle.services.ConfigService;
import org.springframework.web.bind.annotation.*;

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

    @AuthGuard
    @PostMapping("/navbar")
    public void setNavbarLinks(@RequestBody AddNavbarDTO navbarDTO, @GetUser User user) {
        if (user == null) {
            return;
        }
        configService.setNavbar(navbarDTO);
    }
}
