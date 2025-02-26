package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CreditApplicationDTO;
import com.bancopichincha.credito.automotriz.model.CreditApplication;
import com.bancopichincha.credito.automotriz.model.Customer;
import com.bancopichincha.credito.automotriz.model.Vehicle;

import java.util.Date;

public interface ICreditApplicationService {
    CreditApplicationDTO findById(Long id);
    CreditApplicationDTO save(CreditApplication creditApplication);
    CreditApplicationDTO update(CreditApplication creditApplication, Long id);
    CreditApplicationDTO findByVehicle(Vehicle vehicle);
    CreditApplicationDTO findByProductionDateAndCustomer(Date productionDate, Customer customer);

}
