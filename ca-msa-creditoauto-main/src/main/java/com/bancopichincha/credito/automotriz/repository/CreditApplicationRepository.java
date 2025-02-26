package com.bancopichincha.credito.automotriz.repository;

import com.bancopichincha.credito.automotriz.model.CreditApplication;
import com.bancopichincha.credito.automotriz.model.Customer;
import com.bancopichincha.credito.automotriz.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
    Optional<CreditApplication> findByProductionDateAndCustomer(Date productionDate, Customer customer);

    Optional<CreditApplication> findByVehicle(Vehicle vehicle);
}
