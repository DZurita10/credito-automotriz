package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CarYardDTO;
import com.bancopichincha.credito.automotriz.mapper.CarYardMapper;
import com.bancopichincha.credito.automotriz.model.CarYard;
import com.bancopichincha.credito.automotriz.repository.CarYardRespository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarYardServiceTest {
    @InjectMocks
    private CarYardService carYardService;

    @Mock
    private CarYardRespository carYardRespository;


    @Test
    void findCarYardById() {
        CarYard carYard = new CarYard();
        carYard.setId((long) 1);

        carYard.setName("Quicentro");

        when(carYardRespository.findById((long) 1)).thenReturn(Optional.of(carYard));

        CarYardDTO carYardB = carYardService.findCarYardById(carYard.getId());
        assertNotNull(carYardB);
        assertEquals(carYard.getName(), carYardB.getName());

    }

    @Test
    void findByName() {
        CarYard carYard = new CarYard();
        carYard.setId((long) 1);

        carYard.setName("Quicentro");

        when(carYardRespository.findByName("Quicentro")).thenReturn(Optional.of(carYard));

        CarYardDTO carYardB = carYardService.findByName(carYard.getName());
        assertNotNull(carYardB);
        assertEquals(carYard.getName(), carYardB.getName());
    }
}