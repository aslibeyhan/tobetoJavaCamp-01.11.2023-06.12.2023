package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "brands")
@Entity
public class Brand {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
   @OneToMany(mappedBy = "brand")     //***attribute ismi - column değil !!!***
    private List<Car> cars;
   @OneToMany(mappedBy = "brand")
   private List<Model> models;

}
