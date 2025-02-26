package com.bancopichincha.credito.automotriz.mapper;

import com.bancopichincha.credito.automotriz.dto.CarYardDTO;
import com.bancopichincha.credito.automotriz.dto.ExecutiveDTO;
import com.bancopichincha.credito.automotriz.model.CarYard;
import com.bancopichincha.credito.automotriz.model.Executive;

public class ExecutiveMapper {

    public static Executive toExecutive(ExecutiveDTO executiveDTO) {
        if (executiveDTO == null) {
            return null;
        }

        return Executive.builder()
                .identification(executiveDTO.getIdentification())
                .age(executiveDTO.getAge())
                .phone(executiveDTO.getPhone())
                .name(executiveDTO.getName())
                .address(executiveDTO.getAddress())
                .cellPhone(executiveDTO.getCellPhone())
                .lastName(executiveDTO.getLastName())
                .carYard(CarYardMapper.toEntity(executiveDTO.getCarYardDTO()))
                .build();
    }

    public static ExecutiveDTO toExecutiveDTO(Executive executive) {
        if (executive == null) {
            return null;
        }

        return ExecutiveDTO.builder()
                .identification(executive.getIdentification())
                .age(executive.getAge())
                .phone(executive.getPhone())
                .name(executive.getName())
                .address(executive.getAddress())
                .cellPhone(executive.getCellPhone())
                .lastName(executive.getLastName())
                .carYardDTO(CarYardMapper.toDTO(executive.getCarYard()))
                //.carYardDTO(toCarYardDTO(executive.getCarYard()))
                .build();
    }
}

