package com.backend.hydraapi.application.services;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.backend.hydraapi.infrastructure.api.dto.request.TransactionRequest;
import com.backend.hydraapi.infrastructure.api.dto.response.TransactionResponse;

@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private final RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE = "transactions-exchange";

    public TransactionResponse process(TransactionRequest request) {
        var transactionId = UUID.randomUUID();

        rabbitTemplate.convertAndSend(EXCHANGE, "transactions.new", request);
        
        return new TransactionResponse(transactionId, "PROCESSING", LocalDateTime.now());
    }
}
