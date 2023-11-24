package com.tobeto.spring.b.dtos.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class AddUserRequest {
    private String first_name;
    private String last_name ;
    private String email;
    private String  phone;
}
