package com.bancopichincha.credito.automotriz.dto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarYardDTO {

    @CsvBindByPosition(position = 0)
    @NotNull(message = "El nombre del patio es un campo obligatorio")
    private String name;

    @CsvBindByPosition(position = 1)
    @NotNull(message = "La dirección es un campo obligatorio")
    private String address;

    @CsvBindByPosition(position = 2)
    @NotNull(message = "El número de teléfono es un campo obligatorio")
    @Size(min = 5, max = 20, message = "El número de teléfono debe tener 20 caracteres")
    private String phone;
}
