package com.mchg.tadremoelle.controllers.thymeleaf;

import com.mchg.tadremoelle.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminThymeleafController {
    @GetMapping("/admin")
    public String adminDash(HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u == null) {
            return "redirect:/login.html";
        } else {
            return "admin";
        }
    }
}
