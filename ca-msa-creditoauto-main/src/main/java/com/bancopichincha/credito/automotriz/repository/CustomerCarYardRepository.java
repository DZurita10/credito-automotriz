package com.bancopichincha.credito.automotriz.repository;

import com.bancopichincha.credito.automotriz.model.CarYard;
import com.bancopichincha.credito.automotriz.model.Customer;
import com.bancopichincha.credito.automotriz.model.CustomerCarYard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerCarYardRepository extends JpaRepository<CustomerCarYard, Long> {
    Optional<CustomerCarYard> findByCustomer(Customer customerId);

    Optional<CustomerCarYard> findByCarYard(CarYard carYard);

    Optional<CustomerCarYard> findByCustomerAndCarYard(Customer customer, CarYard carYard);
}
