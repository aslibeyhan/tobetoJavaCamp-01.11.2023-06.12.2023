package com.tobeto.spring.b.services.dtos.responses.rental;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.User;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarForRentalResponse;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.user.GetUserListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalListResponse {
    private int id;
    private String rental_message;
    private GetCarForRentalResponse carForRentalResponse;
    private GetUserListResponse userListResponse;

}
