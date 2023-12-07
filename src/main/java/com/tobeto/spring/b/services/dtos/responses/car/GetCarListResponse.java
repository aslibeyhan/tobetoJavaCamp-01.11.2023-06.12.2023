package com.tobeto.spring.b.services.dtos.responses.car;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int id;
    private String plate;
    private int daily_price;
    private GetModelListResponse model;  //veritabanı nesnesini dışarı açamazsın.So response kull.

}
