package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {


    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.car" +
            ".GetCarListResponse(c.id,c.plate,c.daily_price,new com.tobeto.spring.b.services.dtos.responses.model.GetModelListResponse(m.id,m.name,m.year)) " +
            "FROM Car c INNER JOIN c.model m ")
    List<GetCarListResponse> getAll();
}
