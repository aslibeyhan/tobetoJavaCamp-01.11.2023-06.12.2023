package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
   private final BrandRepository brandRepository;

   /* @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> brandListResponses = new ArrayList<>();
        for (Brand brand: brandList) {
            GetBrandListResponse brandResponse = new GetBrandListResponse();
            brandResponse.setId(brand.getId());
            brandResponse.setName(brand.getName());
            brandListResponses.add(brandResponse);
        }
        return brandListResponses;
    }*/

    @Override
    public List<GetBrandListResponse> getByName(String name,int id) {
        List<Brand> brands= brandRepository.findByNameLikeOrIdEquals("%"+name+"%",id);
        //mapleme yapıyoruz.
        List<GetBrandListResponse> response=new ArrayList<>();

        for (Brand brand:brands) {
            response.add(new GetBrandListResponse(brand.getName()));
        }
        return  response;
    }

    @Override
    public List<GetBrandListResponse> search(String name) {
        // List<Brand> brands=brandRepository.search2(name);
         //MAP --- Lambda Expression & Stream API

        return brandRepository.search3(name);
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand= brandRepository.findById(id).orElseThrow();
        GetBrandResponse dto=new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;
    }

    @Override
    public void add( AddBrandRequest addBrandRequest) {
       //Aynı isimde iki marka bulunamaz
        //List<Brand> brandWithSameName=brandRepository.findByName(addBrandRequest.getName().trim()); //trim baş-son boşlukları siler.
        /*if(!brandWithSameName.isEmpty()){
            throw  new RuntimeException("Aynı isimde iki marka eklenemez");
        }*/

        if(brandRepository.existsByName(addBrandRequest.getName().trim())){
            throw  new RuntimeException("Aynı isimde iki marka eklenemez");
        }

        if(addBrandRequest.getName().length()<2){
            throw new RuntimeException("marka adı 2 haneden küçük olamaz");
        }
        Brand brand=new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brandToUpdate = brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);

    }

    @Override
    public void delete(int id) {
        Brand brandToDelete= brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
        //brandRepository.deleteById(id);
    }




}
