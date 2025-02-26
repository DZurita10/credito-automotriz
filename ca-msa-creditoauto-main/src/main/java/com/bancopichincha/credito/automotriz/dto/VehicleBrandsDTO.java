package com.bancopichincha.credito.automotriz.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleBrandsDTO {

    @CsvBindByPosition(position = 0)
    @NotNull(message = "La marca no puede ser nula")
    private String brand;
}
