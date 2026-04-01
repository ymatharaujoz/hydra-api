package com.backend.hydraapi.infrastructure.api.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TransactionRequest(
    @NotBlank(message = "Account ID is required")
    String accountId,

    @NotNull(message = "Amount is required")
    BigDecimal amount,
    
    @Size(max = 255, message = "Description must be less than 255 characters")
    String description
) {}
