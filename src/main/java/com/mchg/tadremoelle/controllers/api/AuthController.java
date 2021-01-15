package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.annotations.AuthGuard;
import com.mchg.tadremoelle.annotations.GetUser;
import com.mchg.tadremoelle.dto.AddUserDTO;
import com.mchg.tadremoelle.dto.LoginDTO;
import com.mchg.tadremoelle.models.User;
import com.mchg.tadremoelle.services.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDTO dto, HttpServletResponse response, HttpSession session) {
        User u  = this.authService.login(dto);

        if (u != null) {
            session.setAttribute("user", u);
            return true;
        }

        response.setStatus(403);
        return false;
    }

    @AuthGuard
    @GetMapping("/logout")
    public boolean logout(HttpSession session) {
        session.removeAttribute("user");
        return true;
    }

    @GetMapping("/me")
    public String me(@GetUser User u) {
        if (u != null) return u.getUsername();
        else return "None";
    }

    @AuthGuard
    @PostMapping("/signup")
    public boolean signup(@Valid @RequestBody AddUserDTO dto) {
        return this.authService.signUp(dto);
    }
}
