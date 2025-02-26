package com.bancopichincha.credito.automotriz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "registration_plate")
    private String registrationPlate;

    @Column(name = "model")
    private String model;

    @Column(name = "appraisal")
    private String appraisal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_brand", referencedColumnName = "id")
    private VehicleBrands vehicleBrands;

    @Column(name = "status", nullable = false)
    private String status;
}
