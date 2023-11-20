package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "cars")
@Entity
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "plate")
    private String plate;
    @Column(name="daily_price")
    private double daily_price;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

   @OneToMany(mappedBy = "car")
    private List<Rental> rentals;
}
