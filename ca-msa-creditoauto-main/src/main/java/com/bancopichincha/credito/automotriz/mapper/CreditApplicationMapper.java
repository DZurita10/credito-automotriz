package com.bancopichincha.credito.automotriz.mapper;

import com.bancopichincha.credito.automotriz.dto.CreditApplicationDTO;
import com.bancopichincha.credito.automotriz.model.CreditApplication;

public class CreditApplicationMapper {
    public static CreditApplicationDTO toDTO(CreditApplication entity) {
        if (entity == null) {
            return null;
        }

        return CreditApplicationDTO.builder()
                .productionDate(entity.getProductionDate())
                .monthsTerm(entity.getMonthsTerm())
                .quotas(entity.getQuotas())
                .entry(entity.getEntry())
                .observation(entity.getObservation())
                .status(entity.getStatus())
                .customer(CustomerMapper.toCustomerDTO(entity.getCustomer()))
                .carYard(CarYardMapper.toDTO(entity.getCarYard()))
                .executive(ExecutiveMapper.toExecutiveDTO(entity.getExecutive()))
                .vehicle(VehicleMapper.toDTO(entity.getVehicle()))
                .build();
    }

    public static CreditApplication toEntity(CreditApplicationDTO dto) {
        if (dto == null) {
            return null;
        }

        return CreditApplication.builder()
                .productionDate(dto.getProductionDate())
                .monthsTerm(dto.getMonthsTerm())
                .quotas(dto.getQuotas())
                .entry(dto.getEntry())
                .observation(dto.getObservation())
                .status(dto.getStatus())
                .customer(CustomerMapper.toCustomer(dto.getCustomer()))
                .carYard(CarYardMapper.toEntity(dto.getCarYard()))
                .executive(ExecutiveMapper.toExecutive(dto.getExecutive()))
                .vehicle(VehicleMapper.toEntity(dto.getVehicle()))
                .build();
    }
}
