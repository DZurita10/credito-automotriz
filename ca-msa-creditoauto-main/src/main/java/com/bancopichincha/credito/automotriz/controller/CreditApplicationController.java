package com.bancopichincha.credito.automotriz.controller;

import com.bancopichincha.credito.automotriz.dto.CreditApplicationDTO;
import com.bancopichincha.credito.automotriz.mapper.CreditApplicationMapper;
import com.bancopichincha.credito.automotriz.service.CreditApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit_application")
@AllArgsConstructor
public class CreditApplicationController {

    private final CreditApplicationService creditApplicationService;

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            CreditApplicationDTO creditApplicationDTO = creditApplicationService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(creditApplicationDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CreditApplicationDTO creditApplicationDTO) {
        try {
            CreditApplicationDTO creditApplication = creditApplicationService.save(CreditApplicationMapper.toEntity(creditApplicationDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(creditApplication);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CreditApplicationDTO creditApplicationDTO, @RequestParam Long id) {
        try {
            CreditApplicationDTO creditApplication = creditApplicationService.update(CreditApplicationMapper.toEntity(creditApplicationDTO), id);
            return ResponseEntity.status(HttpStatus.OK).body(creditApplication);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
