package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.VehicleBrandsDTO;

import java.util.List;

public interface IVehicleBrandsService {
    VehicleBrandsDTO findVehicleBrandsById(Long id);
    VehicleBrandsDTO save(VehicleBrandsDTO vehicleBrandsDTO);
    VehicleBrandsDTO update(VehicleBrandsDTO vehicleBrandsDTO, Long id);
    String deleteVehicleBrandsById(Long id);
    List<VehicleBrandsDTO> massSave(List<VehicleBrandsDTO> vehicleBrandsDTOList);

}
