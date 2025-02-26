package com.bancopichincha.credito.automotriz.mapper;

import com.bancopichincha.credito.automotriz.dto.VehicleBrandsDTO;
import com.bancopichincha.credito.automotriz.dto.VehicleDTO;
import com.bancopichincha.credito.automotriz.model.Vehicle;

public class VehicleMapper {
    public static VehicleDTO toDTO(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
        return VehicleDTO.builder()
                .registrationPlate(vehicle.getRegistrationPlate())
                .model(vehicle.getModel())
                .appraisal(vehicle.getAppraisal())
                .vehicleBrands(VehicleBradsMapper.toDTO(vehicle.getVehicleBrands()))
                .status(vehicle.getStatus())
                .build();
    }

    public static Vehicle toEntity(VehicleDTO vehicleDTO) {
        if (vehicleDTO == null) {
            return null;
        }
        return Vehicle.builder()
                .registrationPlate(vehicleDTO.getRegistrationPlate())
                .model(vehicleDTO.getModel())
                .appraisal(vehicleDTO.getAppraisal())
                .vehicleBrands(VehicleBradsMapper.toEntity(vehicleDTO.getVehicleBrands()))
                .status(vehicleDTO.getStatus())
                .build();
    }
}
