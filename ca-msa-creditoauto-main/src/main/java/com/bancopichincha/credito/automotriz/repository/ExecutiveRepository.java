package com.bancopichincha.credito.automotriz.repository;

import com.bancopichincha.credito.automotriz.model.CarYard;
import com.bancopichincha.credito.automotriz.model.Executive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExecutiveRepository extends JpaRepository<Executive, Long> {
    Optional<List<Executive>> findByCarYard(CarYard carYard);
    Optional<Executive> findByIdentification(String identification);
}
