package com.bancopichincha.credito.automotriz.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vehicle_brands")
@AllArgsConstructor
@NoArgsConstructor
public class VehicleBrands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @CsvBindByPosition(position = 0)
    @Column(name = "brand")
    private String brand;
}
