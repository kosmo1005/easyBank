package com.cool_company.easy_bank.dto.transaction;

import com.cool_company.easy_bank.enums.OperationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionReqDto(

        UUID walletId,

        @Enumerated(EnumType.STRING)
        OperationType operationType,

        @Min(value = 0)
        BigDecimal amount
) {
}
