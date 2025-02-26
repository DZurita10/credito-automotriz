package com.bancopichincha.credito.automotriz.controller;

import com.bancopichincha.credito.automotriz.dto.CustomerDTO;
import com.bancopichincha.credito.automotriz.model.Customer;
import com.bancopichincha.credito.automotriz.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CustomerDTO customerDTO) {
        try {
            customerService.saveCustomer(customerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam String identification) {
        try {
            CustomerDTO customerDTO = customerService.findCustomerByIdentification(identification);
            return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String identification) {
        try {
            customerService.deleteCustomerByIdentification(identification);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid CustomerDTO customerDTO, @RequestParam String identification) {
        try {
            CustomerDTO customer = customerService.updateCustomer(identification, customerDTO);
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
