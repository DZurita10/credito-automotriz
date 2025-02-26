package com.bancopichincha.credito.automotriz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "customer_car_yard")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCarYard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_yard_id", referencedColumnName = "id")
    private CarYard carYard;

    @Column(name = "assignment_date")
    private Date assignmentDate;
}
