package com.bancopichincha.credito.automotriz.repository;

import com.bancopichincha.credito.automotriz.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByIdentification(String identification);
}
