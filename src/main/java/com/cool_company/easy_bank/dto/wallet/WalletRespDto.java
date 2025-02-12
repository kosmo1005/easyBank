package com.cool_company.easy_bank.dto.wallet;

import java.math.BigDecimal;
import java.util.UUID;

public record WalletRespDto(
        UUID walletId,
        BigDecimal totalAmount
) {
}
