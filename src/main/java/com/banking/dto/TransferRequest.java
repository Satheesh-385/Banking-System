package com.banking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TransferRequest {

    @NotBlank(message = "From account cannot be empty")
    private String fromAccount;

    @NotBlank(message = "To account cannot be empty")
    private String toAccount;

    @Positive(message = "Amount must be greater than 0")
    private double amount;
}