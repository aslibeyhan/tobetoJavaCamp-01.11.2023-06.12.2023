package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {
    @GetMapping
    public String get(){
        return "Kategori Alındı";
    }

    @PostMapping
    public String post(){
        return "Kategori Eklendi";
    }

    @PutMapping
    public  String put(){
        return "Kategori Güncellendi";
    }

    @DeleteMapping
    public String delete(){
        return "Kategori Silindi";
    }
}
