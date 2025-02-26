package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.VehicleBrandsDTO;
import com.bancopichincha.credito.automotriz.model.VehicleBrands;
import com.bancopichincha.credito.automotriz.repository.VehicleBrandsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class VehicleBrandsServiceTest {
    @InjectMocks
    private VehicleBrandsService vehicleBrandsService;
    @Mock
    private VehicleBrandsRepository vehicleBrandsRepository;
    @Test
    void findVehicleBrandsById() {
        VehicleBrands vehicleBrands = new VehicleBrands();
        vehicleBrands.setId(1L);
        vehicleBrands.setBrand("BMW");

        when(vehicleBrandsRepository.findById(1L)).thenReturn(Optional.of(vehicleBrands));

        VehicleBrandsDTO vehicleBrandsDTO = vehicleBrandsService.findVehicleBrandsById(1L);
        assertNotNull(vehicleBrandsDTO);
        assertEquals(vehicleBrands.getBrand(), vehicleBrandsDTO.getBrand());

    }
}