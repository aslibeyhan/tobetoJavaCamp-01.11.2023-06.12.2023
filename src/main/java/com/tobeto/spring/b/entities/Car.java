package com.tobeto.spring.b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "cars")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "model_id")
    private Model model;

   @OneToMany(mappedBy = "car")
    private List<Rental> rentals;
}
