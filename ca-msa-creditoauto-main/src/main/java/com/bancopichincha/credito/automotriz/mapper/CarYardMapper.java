package com.bancopichincha.credito.automotriz.mapper;

import com.bancopichincha.credito.automotriz.dto.CarYardDTO;
import com.bancopichincha.credito.automotriz.model.CarYard;

public class CarYardMapper {
    public static CarYardDTO toDTO(CarYard carYard) {
        if (carYard == null) {
            return null;
        }
        return CarYardDTO.builder()
                .name(carYard.getName())
                .address(carYard.getAddress())
                .phone(carYard.getPhone())
                .build();
    }

    public static CarYard toEntity(CarYardDTO carYardDTO) {
        if (carYardDTO == null) {
            return null;
        }
        return CarYard.builder()
                .name(carYardDTO.getName())
                .address(carYardDTO.getAddress())
                .phone(carYardDTO.getPhone())
                .build();
    }
}
