package com.bancopichincha.credito.automotriz.service;


import com.bancopichincha.credito.automotriz.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {

    CustomerDTO findCustomerByIdentification(String identification);
    String deleteCustomerByIdentification(String id);
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(String identification, CustomerDTO customerDTO);
    List<CustomerDTO> massSave(List<CustomerDTO> customerDTOList);
}
