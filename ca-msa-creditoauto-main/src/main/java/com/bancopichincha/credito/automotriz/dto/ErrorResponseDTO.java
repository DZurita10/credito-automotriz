package com.bancopichincha.credito.automotriz.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {
    private int status;
    private String message;
}
