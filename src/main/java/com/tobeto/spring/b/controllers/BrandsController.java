package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.entities.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;


   /* @GetMapping
    public List<GetBrandListResponse> getAll(){

       return  brandService.getAll();
    }*/

    //Brand yerine BrandForDetailDto kullandık.


    @GetMapping()
    public List<GetBrandListResponse> getByName(@RequestParam String name,@RequestParam int id){
        return this.brandService.getByName(name,id);
    }

    @GetMapping("search")
    public List<GetBrandListResponse> search(@RequestParam String name){
        return this.brandService.search(name);
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){

       return brandService.getById(id);
    }


    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest addBrandRequest){
       brandService.add(addBrandRequest);

    }
    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
      brandService.update(updateBrandRequest);

    }

    @DeleteMapping("{id}")
    public  void delete(@PathVariable int id){
       brandService.delete(id);
    }
}
