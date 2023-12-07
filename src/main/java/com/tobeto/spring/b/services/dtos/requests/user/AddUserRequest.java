package com.tobeto.spring.b.services.dtos.requests.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class AddUserRequest {
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name ;
    @NotBlank
    private String email;
    @NotBlank
    private String  phone;
}
