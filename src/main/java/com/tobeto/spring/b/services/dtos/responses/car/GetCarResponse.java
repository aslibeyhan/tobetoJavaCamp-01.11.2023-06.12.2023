package com.tobeto.spring.b.services.dtos.responses.car;

import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private int id;
    private String plate;
    private int daily_price;

}
