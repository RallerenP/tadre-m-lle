package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.dto.LoginDTO;
import com.mchg.tadremoelle.models.User;
import com.mchg.tadremoelle.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/")
    public boolean login(@RequestBody LoginDTO dto, HttpServletResponse response, HttpSession session) {
        User u  = this.authService.login(dto);

        if (u != null) {
            session.setAttribute("user", u);
            return true;
        }
        response.setStatus(404);
        return false;
    }

}
