package com.tobeto.spring.b.dtos.responses.payment;

import com.tobeto.spring.b.entities.RentalDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentListResponse {
       private int id;
       private int total_price;
       private int payment_method;
       private RentalDetail rentalDetail;
}
