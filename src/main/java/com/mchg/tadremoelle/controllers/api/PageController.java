package com.mchg.tadremoelle.controllers.api;

import com.mchg.tadremoelle.annotations.AuthGuard;
import com.mchg.tadremoelle.dto.CreatePageDTO;
import com.mchg.tadremoelle.models.Page;
import com.mchg.tadremoelle.services.PageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    private PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @AuthGuard
    @PostMapping("/")
    public Page add(@RequestBody CreatePageDTO dto) {
        return this.pageService.add(dto);
    }

    @GetMapping("/{url}")
    public Page findByUrl(@PathVariable("url") String url) {
        Page p = this.pageService.findByUrl(url);
        return p;
    }

    @GetMapping("/")
    public List<Page> findAll() {
        return this.pageService.findAll();
    }

    @AuthGuard
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        System.out.println("test1" + id);
        pageService.deleteById(id);
    }
}
