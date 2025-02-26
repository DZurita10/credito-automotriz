package com.bancopichincha.credito.automotriz.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ExecutiveDTO extends PeopleDTO{
    @CsvBindByPosition(position = 6)
    @NotNull(message = "El numero de celular no puede ser nulo")
    @Size(min = 10, max = 10, message = "El numero de celular debe tener 10 caracteres")
    private String cellPhone;

    @CsvBindByPosition(position = 7)
    @NotNull(message = "El patio no puedes er nulo")
    private CarYardDTO carYardDTO;

}
