package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Payment;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.payment" +
            ".GetPaymentListResponse(p.id,p.total_price,p.payment_method," +
            "new com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailResponse(rd.id,rd.start_date,rd.end_date,rd.total_cost))" +
            "FROM Payment p INNER JOIN p.rentalDetail rd")
    public List<GetPaymentListResponse> getAllRentalDetail();
}
