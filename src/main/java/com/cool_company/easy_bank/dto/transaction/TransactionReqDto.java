package com.cool_company.easy_bank.dto.transaction;

import com.cool_company.easy_bank.enums.OperationType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.UUID;

@Validated
public record TransactionReqDto(

        @NotNull(message = "Wallet id cannot be null")
        UUID walletId,

        @NotNull(message = "Operation type cannot be null")
        OperationType operationType,

        @NotNull(message = "Amount cannot be null")
        @DecimalMin(value = "0", message = "Amount must be greater than or equal to zero")
        BigDecimal amount
) {
}
