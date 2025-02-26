package com.bancopichincha.credito.automotriz.mapper;

import com.bancopichincha.credito.automotriz.dto.CustomerCarYardDTO;
import com.bancopichincha.credito.automotriz.model.CustomerCarYard;

public class CustomerCarYardMapper {
    public static CustomerCarYardDTO toDTO(CustomerCarYard entity) {
        if (entity == null) {
            return null;
        }

        return CustomerCarYardDTO.builder()
                .customer(CustomerMapper.toCustomerDTO(entity.getCustomer()))
                .carYard(CarYardMapper.toDTO(entity.getCarYard()))
                .assignmentDate(entity.getAssignmentDate())
                .build();
    }

    public static CustomerCarYard toEntity(CustomerCarYardDTO dto) {
        if (dto == null) {
            return null;
        }

        return CustomerCarYard.builder()
                .customer(CustomerMapper.toCustomer(dto.getCustomer()))
                .carYard(CarYardMapper.toEntity(dto.getCarYard()))
                .assignmentDate(dto.getAssignmentDate())
                .build();
    }
}
