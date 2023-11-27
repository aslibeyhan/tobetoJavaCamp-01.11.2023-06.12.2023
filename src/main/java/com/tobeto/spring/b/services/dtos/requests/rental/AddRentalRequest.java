package com.tobeto.spring.b.services.dtos.requests.rental;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddRentalRequest {
    private String rental_message;

}
