package com.bancopichincha.credito.automotriz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Executive extends People{

    @Column(name = "cell_phone")
    private String cellPhone;

    @ManyToOne
    @JoinColumn(name = "id_car_yard", referencedColumnName = "id")
    private CarYard carYard;
}
