package com.bancopichincha.credito.automotriz.repository;

import com.bancopichincha.credito.automotriz.model.VehicleBrands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleBrandsRepository extends JpaRepository<VehicleBrands, Long> {
    Optional<VehicleBrands> findByBrand(String brand);

}
