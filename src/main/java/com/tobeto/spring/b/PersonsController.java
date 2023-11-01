package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/persons")
public class PersonsController {

    @GetMapping
    public String get(){
        return "Asli";
    }


    @GetMapping("get2")
    public String get2(){
        return "get2";
    }
    @PostMapping
    public String post(){
        return "Beyhan";
    }

    @PutMapping
    public  String put(){
        return "put";
    }

    @DeleteMapping
    public String delete(){
        return "delete";
    }
}
