package com.tobeto.spring.b.services.dtos.requests.model;

import com.tobeto.spring.b.entities.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    @NotBlank
    @NotNull
    private String name;
    private int year;


}
