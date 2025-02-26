package com.bancopichincha.credito.automotriz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCarYardDTO {
    @NotNull(message = "No se ha recibido el cliente")
    private CustomerDTO customer;

    @NotNull(message = "No se ha recibido la fecha de asignacion")
    private Date assignmentDate;

    @NotNull(message = "No se ha recibido el patio")
    private CarYardDTO carYard;
}
