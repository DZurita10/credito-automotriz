package com.bancopichincha.credito.automotriz.repository;

import com.bancopichincha.credito.automotriz.model.CarYard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarYardRespository extends JpaRepository<CarYard, Long> {
    Optional<CarYard> findByName(String name);
}
