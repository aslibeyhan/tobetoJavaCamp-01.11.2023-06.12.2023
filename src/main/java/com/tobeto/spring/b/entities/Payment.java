package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

@Table(name = "payments")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "total_price")
    private int total_price;
    @Column(name = "payment_method")
    private int payment_method;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
