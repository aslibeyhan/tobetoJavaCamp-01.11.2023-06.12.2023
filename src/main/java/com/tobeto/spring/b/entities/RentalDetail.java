package com.tobeto.spring.b.entities;

import ch.qos.logback.core.rolling.helper.RenameUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "rental_details")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "start_date")
    private String start_date;
    @Column(name = "end_date")
    private String end_date;
    @Column(name = "total_cost")
    private int total_cost;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
