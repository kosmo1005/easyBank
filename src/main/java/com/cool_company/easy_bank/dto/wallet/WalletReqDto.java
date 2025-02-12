package com.cool_company.easy_bank.dto.wallet;

import com.cool_company.easy_bank.enums.OperationType;

import java.math.BigDecimal;
import java.util.UUID;

public record WalletReqDto(
        UUID walletId,
        OperationType operationType,
        BigDecimal amount
) {
}
