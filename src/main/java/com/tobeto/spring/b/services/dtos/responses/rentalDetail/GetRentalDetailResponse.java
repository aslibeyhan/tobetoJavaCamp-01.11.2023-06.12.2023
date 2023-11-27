package com.tobeto.spring.b.services.dtos.responses.rentalDetail;

import com.tobeto.spring.b.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalDetailResponse {
    private int id;
    private String start_date;
    private String end_date;
    private int total_cost;

}
