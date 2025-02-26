package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CarYardDTO;
import com.bancopichincha.credito.automotriz.exception.AlreadyExistException;
import com.bancopichincha.credito.automotriz.mapper.CarYardMapper;
import com.bancopichincha.credito.automotriz.model.CarYard;
import com.bancopichincha.credito.automotriz.repository.CarYardRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarYardService implements ICarYardService{
    private final CarYardRespository carYardRepository;

    @Override
    public CarYardDTO findCarYardById(Long id){
        CarYard carYard = carYardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patio no encontrado"));
        return CarYardMapper.toDTO(carYard);
    }

    @Override
    public CarYardDTO findByName(String name){
        CarYard carYard = carYardRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Patio no encontrado"));
        return CarYardMapper.toDTO(carYard);
    }

    @Override
    public CarYardDTO save(CarYardDTO carYardDTO){
        Optional<CarYard> carYard = carYardRepository.findByName(carYardDTO.getName());

        if(carYard.isPresent()){
            throw new AlreadyExistException("El patio ya existe");
        }

        carYardRepository.save(CarYardMapper.toEntity(carYardDTO));
        return carYardDTO;
    }

    @Override
    public CarYardDTO update(CarYardDTO carYardDTO, Long id){
        CarYard carYard = carYardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patio no encontrado"));
        carYard.setName(carYardDTO.getName());
        carYard.setAddress( carYardDTO.getAddress());
        carYard.setPhone( carYardDTO.getPhone());
        carYardRepository.save(carYard);
        return CarYardMapper.toDTO(carYard);
    }

    @Override
    public CarYardDTO delete(Long id){
        CarYard carYard = carYardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patio no encontrado"));
        carYardRepository.delete(carYard);
        return CarYardMapper.toDTO(carYard);
    }

    @Override
    public List<CarYardDTO> massSave(List<CarYardDTO> carYardDTOList){
        List<CarYard> carYards = carYardDTOList.stream()
                .map(CarYardMapper::toEntity)
                .collect(Collectors.toList());

        List<CarYard> carYardsSaved = carYardRepository.saveAll(carYards);

        return carYardsSaved.stream().map(CarYardMapper::toDTO).collect(Collectors.toList());
    }
}
