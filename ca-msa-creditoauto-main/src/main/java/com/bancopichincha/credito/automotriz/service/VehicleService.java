package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.VehicleDTO;
import com.bancopichincha.credito.automotriz.exception.NotFoundException;
import com.bancopichincha.credito.automotriz.mapper.VehicleBradsMapper;
import com.bancopichincha.credito.automotriz.mapper.VehicleMapper;
import com.bancopichincha.credito.automotriz.model.Vehicle;
import com.bancopichincha.credito.automotriz.model.VehicleBrands;
import com.bancopichincha.credito.automotriz.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleService implements IVehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleDTO findVehicleById(Long id){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el vehiculo"));
        return VehicleMapper.toDTO(vehicle);
    }

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicle){
        vehicleRepository.save(VehicleMapper.toEntity(vehicle));
        return vehicle;
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicle, Long id){
        Vehicle vehicleDB = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el vehiculo"));
        VehicleBrands vehicleBrands = VehicleBradsMapper.toEntity(vehicle.getVehicleBrands());

        vehicleDB.setVehicleBrands(vehicleBrands);
        vehicleDB.setAppraisal(vehicle.getAppraisal());
        vehicleDB.setStatus(vehicle.getStatus());
        vehicleDB.setModel(vehicle.getModel());
        vehicleDB.setRegistrationPlate(vehicle.getRegistrationPlate());
        vehicleRepository.save(vehicleDB);
        return VehicleMapper.toDTO(vehicleDB);
    }

    @Override
    public String deleteVehicle(Long id){
        Vehicle vehicleDB = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el vehiculo"));
        vehicleRepository.delete(vehicleDB);
        return "El vehiculo se elimino con exito";
    }

    @Override
    public List<VehicleDTO> findVehicleByModel(String model){
        List<Vehicle> vehicles = vehicleRepository.findByModel(model)
                .orElseThrow(() -> new NotFoundException("No se encontraron los vehiculos"));
        return vehicles.stream()
                .map(VehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> findVehicleByBrand(VehicleBrands brand){
        List<Vehicle> vehicles = vehicleRepository.findByVehicleBrands(brand)
                .orElseThrow(() -> new NotFoundException("No se encontraron los vehiculos"));
        return vehicles.stream()
                .map(VehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO findVehicleByPlate(String plate){
        Vehicle vehicle = vehicleRepository.findByRegistrationPlate(plate)
                .orElseThrow(() -> new NotFoundException("No se encontro el vehiculo"));
        return VehicleMapper.toDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> massSaveVehicle(List<VehicleDTO> vehicleDTOList){
        List<Vehicle> vehicles = vehicleDTOList.stream()
                .map(VehicleMapper::toEntity)
                .collect(Collectors.toList());

        List<Vehicle> savedVehicles = vehicleRepository.saveAll(vehicles);

        return savedVehicles.stream()
                .map(VehicleMapper::toDTO)
                .collect(Collectors.toList());
    }
}
