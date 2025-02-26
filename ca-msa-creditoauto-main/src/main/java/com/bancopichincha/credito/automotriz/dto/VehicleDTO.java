package com.bancopichincha.credito.automotriz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    @NotNull(message = "El numero de placa no puede ser nulo")
    private String registrationPlate;

    @NotNull(message = "El modelo no puede ser nulo")
    private String model;

    @NotNull(message = "El avaluo del vehiculo no puede ser nulo")
    private String appraisal;

    @NotNull(message = "LA marca del vehiculo no puede ser nula")
    private VehicleBrandsDTO vehicleBrands;

    @NotNull(message = "estado necesario")
    private String status;
}
