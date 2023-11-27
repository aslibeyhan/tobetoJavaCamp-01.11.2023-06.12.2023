package com.tobeto.spring.b.services.dtos.responses.payment;

import com.tobeto.spring.b.entities.RentalDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentResponse {
    private int id;
    private int total_price;
    private int payment_method;

}
