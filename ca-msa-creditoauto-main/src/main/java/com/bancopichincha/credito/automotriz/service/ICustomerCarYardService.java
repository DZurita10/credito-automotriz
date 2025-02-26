package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CustomerCarYardDTO;
import com.bancopichincha.credito.automotriz.model.CarYard;
import com.bancopichincha.credito.automotriz.model.Customer;

import java.util.List;

public interface ICustomerCarYardService {
    CustomerCarYardDTO findCustomerCarYardById(Long id);
    CustomerCarYardDTO findCustomerCarYardByCustomer(Customer customer);
    CustomerCarYardDTO findByCarYard(CarYard carYard);
    CustomerCarYardDTO save(CustomerCarYardDTO customerCarYardDTO);
    CustomerCarYardDTO update(CustomerCarYardDTO customerCarYardDTO, Long id);
    String deleteCustomerCarYardById(Long id);
    List<CustomerCarYardDTO> massSave(List<CustomerCarYardDTO> customerCarYardDTOList);
}
