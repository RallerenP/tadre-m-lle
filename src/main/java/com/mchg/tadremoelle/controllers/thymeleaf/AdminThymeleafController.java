package com.mchg.tadremoelle.controllers.thymeleaf;

import com.mchg.tadremoelle.annotations.GetUser;
import com.mchg.tadremoelle.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminThymeleafController {
    @GetMapping("/admin")
    public String adminDash(@GetUser User u) {
        if (u == null) {
            return "redirect:/login.html";
        } else {
            return "admin";
        }
    }

    @GetMapping("/navbar/edit")
    public String navbarEditor(@GetUser User u) {
        if (u == null) {
            return "redirect:/login.html";
        } else {
            return "navbar-editor";
        }
    }

    @GetMapping("/events/edit")
    public String eventEditor(@GetUser User u) {
        if (u == null) {
            return "redirect:/login.html";
        } else {
            return "events";
        }
    }

    @GetMapping("/artikel/opret")
    public String createPage(@GetUser User u) {
        if (u == null) {
            return "redirect:/login.html";
        } else {
            return "create-page";
        }
    }

    @GetMapping("/prices/edit")
    public String editPrices(@GetUser User u) {
        if (u == null) {
            return "redirect:/login.html";
        } else {
            return "edit-price";
        }
    }

    @GetMapping("/album/new")
    public String createAlbum(@GetUser User u) {
        if (u == null) {
            return "redirect:/login.html";
        } else {
            return "create-album";
        }
    }

    @GetMapping("/signup")
    public String createUser(@GetUser User u) {
        if (u == null) {
            return "redirect:/login.html";
        } else {
            return "create-user";
        }
    }
}
