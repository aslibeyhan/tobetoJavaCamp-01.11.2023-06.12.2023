package com.tobeto.spring.b.services.dtos.responses.model;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelListResponse {
    private int id;
    private String name;
    private int year;
    private  GetBrandListResponse brandListResponse;


}
