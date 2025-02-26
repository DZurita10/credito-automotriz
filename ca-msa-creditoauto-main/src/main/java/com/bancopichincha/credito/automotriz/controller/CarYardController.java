package com.bancopichincha.credito.automotriz.controller;

import com.bancopichincha.credito.automotriz.dto.CarYardDTO;
import com.bancopichincha.credito.automotriz.service.CarYardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caryard")
@AllArgsConstructor
public class CarYardController {
    private final CarYardService carYardService;

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            CarYardDTO carYardDTO = carYardService.findCarYardById(id);
            return ResponseEntity.status(HttpStatus.OK).body(carYardDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CarYardDTO carYardDTO) {
        try {
            carYardService.save(carYardDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(carYardDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            carYardService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CarYardDTO carYardDTO, @RequestParam Long id ) {
        try {
            CarYardDTO carYard = carYardService.update(carYardDTO, id);
            return ResponseEntity.status(HttpStatus.OK).body(carYard);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
