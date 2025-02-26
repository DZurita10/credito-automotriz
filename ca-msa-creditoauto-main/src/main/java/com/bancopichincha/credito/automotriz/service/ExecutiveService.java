package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CarYardDTO;
import com.bancopichincha.credito.automotriz.dto.ExecutiveDTO;
import com.bancopichincha.credito.automotriz.exception.AlreadyExistException;
import com.bancopichincha.credito.automotriz.exception.NotFoundException;
import com.bancopichincha.credito.automotriz.mapper.ExecutiveMapper;
import com.bancopichincha.credito.automotriz.model.CarYard;
import com.bancopichincha.credito.automotriz.model.Executive;
import com.bancopichincha.credito.automotriz.repository.CarYardRespository;
import com.bancopichincha.credito.automotriz.repository.ExecutiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExecutiveService implements IExecutiveService {
    private final ExecutiveRepository executiveRepository;
    private final CarYardRespository carYardRespository;

    @Override
    public ExecutiveDTO findExecutiveByIdentification(String identification){
        Executive executive = executiveRepository.findByIdentification(identification)
                .orElseThrow(() -> new NotFoundException("No se encontro al ejecutivo"));
        return ExecutiveMapper.toExecutiveDTO(executive);
    }

    @Override
    public ExecutiveDTO saveExecutive(ExecutiveDTO executive){
        Optional<Executive> executiveDB = executiveRepository.findByIdentification(executive.getIdentification());
        if (executiveDB.isEmpty()) {
            executiveRepository.save(ExecutiveMapper.toExecutive(executive));
            return executive;
        }
        throw new AlreadyExistException("El ejecutivo ya se encuentra registrado");
    }

    @Override
    public String deleteExecutiveByIdentification(String identification){
        Executive executive = executiveRepository.findByIdentification(identification)
                .orElseThrow(()-> new NotFoundException("No se encontro al ejecutivo"));
        executiveRepository.delete(executive);
        return "Ejecutivo eliminado: " + identification;
    }

    @Override
    public ExecutiveDTO updateExecutive(ExecutiveDTO executive, String identification){
        Executive executiveDB = executiveRepository.findByIdentification(identification)
                .orElseThrow(() -> new NotFoundException("No se encontro al ejecutivo"));

        CarYard carYard = CarYard.builder()
                .name(executive.getCarYardDTO().getName())
                .phone(executive.getCarYardDTO().getPhone())
                .address(executive.getCarYardDTO().getAddress())
                .build();

        executiveDB.setName(executive.getName());
        executiveDB.setAddress(executive.getAddress());
        executiveDB.setPhone(executive.getPhone());
        executiveDB.setCellPhone(executive.getCellPhone());
        executiveDB.setLastName(executive.getLastName());
        executiveDB.setCarYard(carYard);
        executiveDB.setAge(executive.getAge());
        executiveRepository.save(executiveDB);
        return executive;
    }

    @Override
    public List<ExecutiveDTO> findByCarYard(Long carYard){
        CarYard carYardDB = carYardRespository.findById(carYard)
                .orElseThrow(() -> new NotFoundException("No se encontro al patio"));
        List<Executive> executive = executiveRepository.findByCarYard(carYardDB)
                .orElseThrow(() -> new NotFoundException("No se encontro al ejecutivo"));
        return executive.stream().map(ExecutiveMapper::toExecutiveDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExecutiveDTO> massSave(List<ExecutiveDTO> executives){
        List<Executive> executiveList = executives.stream()
                .map(ExecutiveMapper::toExecutive)
                .collect(Collectors.toList());
        List<Executive> savedExecutives = executiveRepository.saveAll(executiveList);
        return savedExecutives.stream().map(ExecutiveMapper::toExecutiveDTO).collect(Collectors.toList());
    }
}
