package com.tobeto.spring.b.services.dtos.requests.car;

import com.tobeto.spring.b.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private String plate;
    private int daily_price;

}

