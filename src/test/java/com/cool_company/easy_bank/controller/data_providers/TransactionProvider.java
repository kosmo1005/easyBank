package com.cool_company.easy_bank.controller.data_providers;

import com.cool_company.easy_bank.controller.transaction.impl.TransactionControllerImpl;
import com.cool_company.easy_bank.dto.transaction.TransactionReqDto;
import com.cool_company.easy_bank.enums.OperationType;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionProvider {

    public static final UUID WALLET_ID = UUID.fromString("32e2a465-4945-4f5e-81df-63e1780df364");

    /**
     * @return {@link TransactionReqDto}, который передается в параметры
     * метода контроллера {@link TransactionControllerImpl#processTransaction}
     */
    public static TransactionReqDto getReqDto_1() {
        return new TransactionReqDto(WALLET_ID, OperationType.DEPOSIT, BigDecimal.valueOf(1000));
    }

    /**
     * @return {@link TransactionReqDto}, который передается в параметры
     * метода контроллера {@link TransactionControllerImpl#processTransaction}
     * и UUID = null.
     */
    public static TransactionReqDto getInvalidReqDto_2() {
        return new TransactionReqDto(null, OperationType.DEPOSIT, BigDecimal.valueOf(1000));
    }
}
