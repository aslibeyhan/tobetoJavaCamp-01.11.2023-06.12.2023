package com.tobeto.spring.b.services.dtos.requests.car;

import com.tobeto.spring.b.entities.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @NotBlank
    @NotNull
    private String plate;
    private int daily_price;

}

