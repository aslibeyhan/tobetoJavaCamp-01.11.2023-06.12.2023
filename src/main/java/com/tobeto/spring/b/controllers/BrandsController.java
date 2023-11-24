package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandRepository brandRepository;
    //final ctor blok dışında set edemezsin.

    //dependency -- bağımlılık
    //injection -- enjekte etme
    public BrandsController(BrandRepository brandRepository){
         this.brandRepository=brandRepository;
    }
  //Spring IoC  container
    @GetMapping
    public List<GetBrandListResponse> getAll(){

        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> brandListResponses = new ArrayList<GetBrandListResponse>();
        for (Brand brand: brandList) {
            GetBrandListResponse brandResponse = new GetBrandListResponse();
            brandResponse.setId(brand.getId());
            brandResponse.setName(brand.getName());
            brandListResponses.add(brandResponse);
        }
        return brandListResponses;
    }

    //Brand yerine BrandForDetailDto kullandık.

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){

        //optional -- > ilgili filtreden veri dönmeyebilir
        //ilgili veri varsa çalıştırır,yoksa hata fırlatır.

        Brand brand= brandRepository.findById(id).orElseThrow();
        GetBrandResponse dto=new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;
    }

    //Brand yerine BrandForAddDto kullandık.
    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        Brand brand=new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);

    }
    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        Brand brandToUpdate = brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);

    }

    @DeleteMapping("{id}")
    public  void delete(@PathVariable int id){
      Brand brandToDelete= brandRepository.findById(id).orElseThrow();
      brandRepository.delete(brandToDelete);
        //brandRepository.deleteById(id);
    }
}
