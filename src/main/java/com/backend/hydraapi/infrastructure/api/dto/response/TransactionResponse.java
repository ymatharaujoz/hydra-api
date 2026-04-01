package com.backend.hydraapi.infrastructure.api.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionResponse(
    UUID id,
    String status,
    LocalDateTime timestamp
) {}
