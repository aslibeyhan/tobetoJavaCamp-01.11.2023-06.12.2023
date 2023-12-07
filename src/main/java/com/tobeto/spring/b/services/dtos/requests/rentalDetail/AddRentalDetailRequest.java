package com.tobeto.spring.b.services.dtos.requests.rentalDetail;

import com.tobeto.spring.b.entities.Rental;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class AddRentalDetailRequest {
    @NotNull
    private String start_date;
    private String end_date;
    private int total_cost;

}
