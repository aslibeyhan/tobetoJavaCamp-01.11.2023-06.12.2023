package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.RentalDetail;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalDetailRepository extends JpaRepository<RentalDetail,Integer> {
    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailListResponse(" +
            "rd.id, rd.start_date,rd.end_date,rd.total_cost ," +  // RentalDetail alanları
            "new com.tobeto.spring.b.services.dtos.responses.rental.GetRentalResponse(r.id, r.rental_message))" +
            "FROM RentalDetail rd " +
            "INNER JOIN rd.rental r " )
    List<GetRentalDetailListResponse> getAllRental();
}
