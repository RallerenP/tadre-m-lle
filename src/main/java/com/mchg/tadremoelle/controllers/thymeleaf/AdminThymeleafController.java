package com.mchg.tadremoelle.controllers.thymeleaf;

import com.mchg.tadremoelle.annotations.AuthGuard;
import com.mchg.tadremoelle.annotations.GetUser;
import com.mchg.tadremoelle.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminThymeleafController {
    @AuthGuard
    @GetMapping("/admin")
    public String adminDash() {
        return "admin";
    }

    @AuthGuard
    @GetMapping("/navbar/edit")
    public String navbarEditor() {
        return "navbar-editor";
    }

    @AuthGuard
    @GetMapping("/events/edit")
    public String eventEditor() {
        return "events";
    }

    @AuthGuard
    @GetMapping("/artikel/opret")
    public String createPage() {
        return "create-page";
    }

    @AuthGuard
    @GetMapping("/prices/edit")
    public String editPrices() {
        return "edit-price";
    }

    @AuthGuard
    @GetMapping("/album/ny")
    public String createAlbum() {
        return "create-album";
    }

    @AuthGuard
    @GetMapping("/signup")
    public String createUser() {
        return "create-user";
    }

    @AuthGuard
    @GetMapping("/sider")
    public String pageList() {
        return "page-list";
    }

    @AuthGuard
    @GetMapping("/sider/rediger/**")
    public String pageEditor() {
        return "edit-page";
    }

}
