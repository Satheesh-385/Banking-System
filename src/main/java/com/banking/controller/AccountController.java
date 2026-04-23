package com.banking.controller;

import com.banking.dto.TransferRequest;
import com.banking.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferRequest request) {

        service.transfer(
                request.getFromAccount(),
                request.getToAccount(),
                request.getAmount()
        );

        return ResponseEntity.ok("Transfer successful");
    }
}