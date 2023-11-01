package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    @GetMapping
    public String get(){
        return "Ürün Alındı";
    }

    @PostMapping
    public String post(){
        return "Ürün Eklendi";
    }

    @PutMapping
    public  String put(){
        return "Ürün Güncellendi";
    }

    @DeleteMapping
    public String delete(){
        return "Ürün Silindi";
    }
}
