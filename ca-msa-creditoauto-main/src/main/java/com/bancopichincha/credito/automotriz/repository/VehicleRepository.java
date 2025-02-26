package com.bancopichincha.credito.automotriz.repository;

import com.bancopichincha.credito.automotriz.model.Vehicle;
import com.bancopichincha.credito.automotriz.model.VehicleBrands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByRegistrationPlate(String registrationPlate);
    Optional<List<Vehicle>> findByModel(String model);
    Optional<List<Vehicle>> findByVehicleBrands(VehicleBrands vehicleBrands);
}
