package com.mchg.tadremoelle.controllers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageThymeleafController {
    @GetMapping("/artikel/**")
    public String getPage() {
        return "artikel";
    }
}
