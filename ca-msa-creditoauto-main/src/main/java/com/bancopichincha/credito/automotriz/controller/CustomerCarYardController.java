package com.bancopichincha.credito.automotriz.controller;

import com.bancopichincha.credito.automotriz.dto.CustomerCarYardDTO;
import com.bancopichincha.credito.automotriz.service.CustomerCarYardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer_caryard")
@AllArgsConstructor
public class CustomerCarYardController {

    private final CustomerCarYardService customerCarYardService;

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            CustomerCarYardDTO customerCarYardDTO = customerCarYardService.findCustomerCarYardById(id);
            return ResponseEntity.status(HttpStatus.OK).body(customerCarYardDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CustomerCarYardDTO customerCarYardDTO) {
        try {
            CustomerCarYardDTO customerCarYard = customerCarYardService.save(customerCarYardDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(customerCarYard);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CustomerCarYardDTO customerCarYardDTO, Long id) {
        try {
            CustomerCarYardDTO customerCarYard = customerCarYardService.update(customerCarYardDTO, id);
            return ResponseEntity.status(HttpStatus.OK).body(customerCarYard);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            customerCarYardService.deleteCustomerCarYardById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Customer Car Yard Deleted");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
