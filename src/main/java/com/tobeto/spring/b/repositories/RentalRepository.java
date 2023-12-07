package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Rental;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.rental" +
            ".GetRentalListResponse(r.id,r.rental_message,new com.tobeto.spring.b.services.dtos.responses.car.GetCarForRentalResponse(c.plate,c.daily_price))" +
            "FROM Rental r INNER JOIN r.car c")
    List<GetRentalListResponse> getAll();

    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.rental.GetRentalListResponse(" +
            "r.id, r.rental_message, " +
            "new com.tobeto.spring.b.services.dtos.responses.car.GetCarForRentalResponse(c.plate, c.daily_price), " +
            "new com.tobeto.spring.b.services.dtos.responses.user.GetUserListResponse(u.id, u.first_name, u.last_name, u.email, u.phone)) " +
            "FROM Rental r " +
            "INNER JOIN r.car c " +  // İlk INNER JOIN
            "INNER JOIN r.user u")   // İkinci INNER JOIN
    List<GetRentalListResponse> getAllUser();
}
