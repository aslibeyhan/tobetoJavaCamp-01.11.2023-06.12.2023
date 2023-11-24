package com.tobeto.spring.b.dtos.requests.rentalDetail;

import com.tobeto.spring.b.entities.Rental;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class UpdateRentalDetailRequest {
    private int id;
    private String start_date;
    private String end_date;
    private int total_cost;
    private Rental rental;
}
