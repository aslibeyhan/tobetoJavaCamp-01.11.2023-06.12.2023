package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
