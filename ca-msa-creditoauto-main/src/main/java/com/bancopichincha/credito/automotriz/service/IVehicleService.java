package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.VehicleDTO;
import com.bancopichincha.credito.automotriz.model.VehicleBrands;

import java.util.List;

public interface IVehicleService {
    VehicleDTO findVehicleById(Long id);
    VehicleDTO saveVehicle(VehicleDTO vehicle);
    VehicleDTO updateVehicle(VehicleDTO vehicle, Long id);
    String deleteVehicle(Long id);
    List<VehicleDTO> findVehicleByModel(String model);
    List<VehicleDTO> findVehicleByBrand(VehicleBrands brand);
    VehicleDTO findVehicleByPlate(String plate);
    List<VehicleDTO> massSaveVehicle(List<VehicleDTO> vehicleDTOList);
}
