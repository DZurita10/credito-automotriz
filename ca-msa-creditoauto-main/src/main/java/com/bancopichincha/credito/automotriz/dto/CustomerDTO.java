package com.bancopichincha.credito.automotriz.dto;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends PeopleDTO{

    @CsvBindByPosition(position = 6)
    @CsvDate("yyyy-MM-dd")
    private Date birthDate;

    @NotNull(message = "El estado civil no pude estar vacio")
    @CsvBindByPosition(position = 7)
    private String maritalStatus;

    @NotNull(message = "La identificacion del conyugue no puede ser nula")
    @CsvBindByPosition(position = 8)
    private String spouseIdentification;

    @NotNull(message = "El nombre del conyugue no puede ser nulo")
    @CsvBindByPosition(position = 9)
    private String spouseName;

    @NotNull(message = "El dato si es sujeto a credito es requerido")
    @CsvBindByPosition(position = 10)
    private Boolean creditSubject;
}
