package com.cool_company.easy_bank.controller.data_providers;

import com.cool_company.easy_bank.controller.wallet.impl.WalletControllerImpl;
import com.cool_company.easy_bank.dto.wallet.WalletRespDto;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletProvider {

    public static final UUID WALLET_ID = UUID.fromString("32e2a465-4945-4f5e-81df-63e1780df364");

    /**
     * @return {@link WalletRespDto}, который должен быть возвращен
     * методом контроллера {@link WalletControllerImpl#addNewWallet()}
     */
    public static WalletRespDto getWalletRespDto_1(){
        return new WalletRespDto(WALLET_ID, BigDecimal.ZERO);
    }

}
