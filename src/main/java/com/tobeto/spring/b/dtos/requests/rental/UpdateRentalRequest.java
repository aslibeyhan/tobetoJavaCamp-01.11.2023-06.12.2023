package com.tobeto.spring.b.dtos.requests.rental;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
    private int id;
    private Car car;
    private User user;
}
