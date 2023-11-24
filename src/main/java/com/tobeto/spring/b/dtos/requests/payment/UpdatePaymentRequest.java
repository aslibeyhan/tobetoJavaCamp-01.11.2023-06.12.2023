package com.tobeto.spring.b.dtos.requests.payment;

import com.tobeto.spring.b.entities.RentalDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {
    private int id;
    private int payment_method;
    private RentalDetail rentalDetail;
}
