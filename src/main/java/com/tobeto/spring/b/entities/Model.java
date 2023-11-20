package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

@Table(name = "models")
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;

    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
