package com.bancopichincha.credito.automotriz.controller;

import com.bancopichincha.credito.automotriz.dto.VehicleDTO;
import com.bancopichincha.credito.automotriz.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> findByRegistrationPlate(@RequestParam String registrationPlate) {
        try {
            VehicleDTO vehicleDTO = vehicleService.findVehicleByPlate(registrationPlate);
            return ResponseEntity.status(HttpStatus.OK).body(vehicleDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody VehicleDTO vehicleDTO) {
        try {
            VehicleDTO vehicle = vehicleService.saveVehicle(vehicleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody VehicleDTO vehicleDTO, @RequestParam Long id) {
        try {
            VehicleDTO vehicle = vehicleService.updateVehicle(vehicleDTO, id);
            return ResponseEntity.status(HttpStatus.OK).body(vehicle);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
