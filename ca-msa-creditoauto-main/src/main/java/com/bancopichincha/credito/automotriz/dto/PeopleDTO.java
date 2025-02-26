package com.bancopichincha.credito.automotriz.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@SuperBuilder
@NoArgsConstructor
public class PeopleDTO {
    @CsvBindByPosition(position = 0)
    @NotNull(message = "El numero de identificacion no puede ser nula")
    private String identification;

    @CsvBindByPosition(position = 1)
    @NotNull(message = "Los nombres no pueden ser nulos")
    private String name;

    @CsvBindByPosition(position = 2)
    @NotNull(message = "La edad no puede ser nula")
    private Integer age;

    @CsvBindByPosition(position = 3)
    @NotNull(message = "Los apellido no pueden ser nulos")
    private String lastName;

    @CsvBindByPosition(position = 4)
    @NotNull(message = "Los direccion no puede ser nula")
    private String address;

    @CsvBindByPosition(position = 5)
    @NotNull(message = "El numero de telefono no puede ser nulo")
    @Size(min = 10, max = 20, message = "El numero de telefono debe tener 20 caracteres")
    private String phone;
}
