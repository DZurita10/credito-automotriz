package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CarYardDTO;

import java.util.List;

public interface ICarYardService {
    CarYardDTO findCarYardById(Long id);
    CarYardDTO findByName(String name);
    CarYardDTO save(CarYardDTO carYardDTO);
    CarYardDTO update(CarYardDTO carYardDTO, Long id);
    CarYardDTO delete(Long id);
    List<CarYardDTO> massSave(List<CarYardDTO> carYardDTOList);
}
