package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.VehicleBrandsDTO;
import com.bancopichincha.credito.automotriz.exception.AlreadyExistException;
import com.bancopichincha.credito.automotriz.exception.NotFoundException;
import com.bancopichincha.credito.automotriz.mapper.VehicleBradsMapper;
import com.bancopichincha.credito.automotriz.model.VehicleBrands;
import com.bancopichincha.credito.automotriz.repository.VehicleBrandsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleBrandsService implements IVehicleBrandsService {
    private final VehicleBrandsRepository vehicleBrandsRepository;

    @Override
    public VehicleBrandsDTO findVehicleBrandsById(Long id){
        VehicleBrands vehicleBrands = vehicleBrandsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encuentra ningun vehiculo con ese id"));
        return VehicleBradsMapper.toDTO(vehicleBrands);
    }

    @Override
    public VehicleBrandsDTO save(VehicleBrandsDTO vehicleBrandsDTO){
        Optional<VehicleBrands> vehicleBrands = vehicleBrandsRepository.findByBrand(vehicleBrandsDTO.getBrand());
        if (vehicleBrands.isPresent()){
            throw new AlreadyExistException("Ya existe un vehiculo con ese nombre");
        }
        vehicleBrandsRepository.save(VehicleBradsMapper.toEntity(vehicleBrandsDTO));
        return vehicleBrandsDTO;
    }

    @Override
    public VehicleBrandsDTO update(VehicleBrandsDTO vehicleBrandsDTO, Long id){
        VehicleBrands vehicleBrands = vehicleBrandsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un vehiculo con ese id"));
        vehicleBrands.setBrand(vehicleBrandsDTO.getBrand());
        vehicleBrandsRepository.save(vehicleBrands);
        return vehicleBrandsDTO;
    }

    @Override
    public String deleteVehicleBrandsById(Long id){
        VehicleBrands vehicleBrands = vehicleBrandsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un vehiculo con ese id"));
        vehicleBrandsRepository.delete(vehicleBrands);
        return "Vehiculos removidos correctamente";
    }

    public List<VehicleBrandsDTO> massSave(List<VehicleBrandsDTO> vehicleBrandsDTOList){
        List<VehicleBrands> vehicleBrands = vehicleBrandsDTOList.stream()
                .map(VehicleBradsMapper::toEntity)
                .collect(Collectors.toList());

        List<VehicleBrands> vehicleBrandsSave = vehicleBrandsRepository.saveAll(vehicleBrands);
        return vehicleBrandsSave.stream()
                .map(VehicleBradsMapper::toDTO)
                .collect(Collectors.toList());

    }
}
