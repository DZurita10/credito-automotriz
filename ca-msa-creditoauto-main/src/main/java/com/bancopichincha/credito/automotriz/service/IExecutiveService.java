package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.ExecutiveDTO;

import java.util.List;

public interface IExecutiveService {
    ExecutiveDTO findExecutiveByIdentification(String identification);
    ExecutiveDTO saveExecutive(ExecutiveDTO executive);
    String deleteExecutiveByIdentification(String identification);
    ExecutiveDTO updateExecutive(ExecutiveDTO executive, String identification);
    List<ExecutiveDTO> findByCarYard(Long carYard);
    List<ExecutiveDTO> massSave(List<ExecutiveDTO> executives);
}
