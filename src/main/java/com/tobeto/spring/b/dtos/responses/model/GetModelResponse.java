package com.tobeto.spring.b.dtos.responses.model;

import com.tobeto.spring.b.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelResponse {
    private int id;
    private String name;
    private int year;
    private Brand brand;
}
