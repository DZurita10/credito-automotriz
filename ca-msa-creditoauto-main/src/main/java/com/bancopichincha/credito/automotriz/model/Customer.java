package com.bancopichincha.credito.automotriz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

import com.opencsv.bean.CsvDate;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer extends People{

    @CsvDate(value = "yyyy-MM-dd")
    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "spouse_identification")
    private String spouseIdentification;

    @Column(name = "spouse_name")
    private String spouseName;

    @Column(name = "credit_subject")
    private Boolean creditSubject;

}
