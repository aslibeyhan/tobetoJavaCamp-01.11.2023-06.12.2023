package com.tobeto.spring.b.services.dtos.requests.model;

import com.tobeto.spring.b.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    private String name;
    private int year;


}
