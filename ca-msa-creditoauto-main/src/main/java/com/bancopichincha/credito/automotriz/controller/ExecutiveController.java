package com.bancopichincha.credito.automotriz.controller;

import com.bancopichincha.credito.automotriz.dto.ExecutiveDTO;
import com.bancopichincha.credito.automotriz.service.ExecutiveService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/executive")
@AllArgsConstructor
public class ExecutiveController {

    private final ExecutiveService executiveService;

    @GetMapping
    public ResponseEntity<?> findByIdentification(@RequestParam String identification) {
        try {
            ExecutiveDTO executiveDTO = executiveService.findExecutiveByIdentification(identification);
            return ResponseEntity.status(HttpStatus.OK).body(executiveDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ExecutiveDTO executiveDTO) {
        try {
            ExecutiveDTO executive = executiveService.saveExecutive(executiveDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(executive);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ExecutiveDTO executiveDTO, @RequestParam String identification) {
        try {
            ExecutiveDTO executive = executiveService.updateExecutive(executiveDTO, identification);
            return ResponseEntity.status(HttpStatus.OK).body(executive);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String identification) {
        try {
            executiveService.deleteExecutiveByIdentification(identification);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
