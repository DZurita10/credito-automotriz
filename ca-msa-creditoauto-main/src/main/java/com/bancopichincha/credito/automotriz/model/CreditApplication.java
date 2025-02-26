package com.bancopichincha.credito.automotriz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "credit_application")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "production_date")
    private Date productionDate;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_car_yard", referencedColumnName = "id")
    private CarYard carYard;

    @ManyToOne
    @JoinColumn(name = "id_executive", referencedColumnName = "id")
    private Executive executive;

    @ManyToOne
    @JoinColumn(name = "id_vehicle", referencedColumnName = "id")
    private Vehicle vehicle;

    @Column(name = "months_term", nullable = false)
    private Integer monthsTerm;

    @Column(name = "quotas", nullable = false)
    private Integer quotas;

    @Column(name = "entry", nullable = false)
    private BigDecimal entry;

    @Column(name = "observation", nullable = false)
    private String observation;

    @Column(name = "status", nullable = false)
    private String status;

}
