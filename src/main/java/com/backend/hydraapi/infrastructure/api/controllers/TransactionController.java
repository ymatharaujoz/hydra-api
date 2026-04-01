package com.backend.hydraapi.infrastructure.api.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.hydraapi.application.services.TransactionService;
import com.backend.hydraapi.infrastructure.api.dto.request.TransactionRequest;
import com.backend.hydraapi.infrastructure.api.dto.response.TransactionResponse;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponse> process(@RequestBody TransactionRequest request) {
        var response = transactionService.process(request);
        return ResponseEntity.accepted().body(response);
    }
}
