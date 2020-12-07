package com.mchg.tadremoelle.controllers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexThymeLeafController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
