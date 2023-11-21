package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
