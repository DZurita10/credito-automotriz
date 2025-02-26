package com.bancopichincha.credito.automotriz.mapper;

import com.bancopichincha.credito.automotriz.dto.CustomerDTO;
import com.bancopichincha.credito.automotriz.model.Customer;

public class CustomerMapper {
    public static Customer toCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .identification(customerDTO.getIdentification())
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .age(customerDTO.getAge())
                .address(customerDTO.getAddress())
                .phone(customerDTO.getPhone())
                .birthdate(customerDTO.getBirthDate())
                .maritalStatus(customerDTO.getMaritalStatus())
                .spouseIdentification(customerDTO.getSpouseIdentification())
                .spouseName(customerDTO.getSpouseName())
                .creditSubject(customerDTO.getCreditSubject())
                .build();
    }

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .identification(customer.getIdentification())
                .name(customer.getName())
                .lastName(customer.getLastName())
                .age(customer.getAge())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .birthDate(customer.getBirthdate())
                .maritalStatus(customer.getMaritalStatus())
                .spouseIdentification(customer.getSpouseIdentification())
                .spouseName(customer.getSpouseName())
                .creditSubject(customer.getCreditSubject())
                .build();
    }

}
