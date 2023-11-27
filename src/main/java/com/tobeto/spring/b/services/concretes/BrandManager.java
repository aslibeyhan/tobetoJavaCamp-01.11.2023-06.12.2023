package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
   private final BrandRepository brandRepository;
    @Override
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
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand= brandRepository.findById(id).orElseThrow();
        GetBrandResponse dto=new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;
    }

    @Override
    public void add(AddBrandRequest addBrandRequest) {

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
