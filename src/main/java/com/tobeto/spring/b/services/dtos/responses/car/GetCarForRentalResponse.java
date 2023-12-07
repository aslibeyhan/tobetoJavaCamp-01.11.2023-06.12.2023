package com.tobeto.spring.b.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarForRentalResponse {
    private String plate;
    private  int daily_price;
}
