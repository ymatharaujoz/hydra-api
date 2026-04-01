package com.backend.hydraapi.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(
    UUID uuid,
    String accountId,
    BigDecimal amount,
    String description,
    LocalDateTime createdAt
) {
    public Transaction {
        if (uuid == null || uuid.toString().isBlank()) {
            throw new IllegalArgumentException("UUID cannot be null or empty");
        }

        if (accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }

        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
