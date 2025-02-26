package com.bancopichincha.credito.automotriz.mapper;

import com.bancopichincha.credito.automotriz.dto.VehicleBrandsDTO;
import com.bancopichincha.credito.automotriz.model.VehicleBrands;

public class VehicleBradsMapper {
    public static VehicleBrandsDTO toDTO(VehicleBrands vehicleBrands) {
        if (vehicleBrands == null) {
            return null;
        }
        return VehicleBrandsDTO.builder()
                .brand(vehicleBrands.getBrand())
                .build();
    }

    public static VehicleBrands toEntity(VehicleBrandsDTO vehicleBrandsDTO) {
        if (vehicleBrandsDTO == null) {
            return null;
        }
        return new VehicleBrands(null, vehicleBrandsDTO.getBrand());
    }
}
