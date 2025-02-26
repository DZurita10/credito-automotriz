package com.bancopichincha.credito.automotriz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplicationDTO {

    @NotNull(message = "La fecha de eleaboracion es requerida")
    private Date productionDate;

    @NotNull(message = "Los meses de plazo son requeridos")
    private Integer monthsTerm;

    @NotNull(message = "Las cuotas no pueden ser nulas")
    private Integer quotas;

    @NotNull(message = "El valor de la entrada no puede ser nulo")
    private BigDecimal entry;

    @NotNull(message = "La observacion no puede ser nula")
    private String observation;

    @NotNull(message = "El estado de la solicitud de credito no puede ser nulo")
    private String status;

    @NotNull(message = "El cliente no puede ser nulo")
    private CustomerDTO customer;

    @NotNull(message = "El patio no puede ser nulo")
    private CarYardDTO carYard;

    @NotNull(message = "El ejecutivo no puede ser nulo")
    private ExecutiveDTO executive;

    @NotNull(message = "El vehiculo no puede ser nulo")
    private VehicleDTO vehicle;
}
