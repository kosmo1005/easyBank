package com.cool_company.easy_bank.controller.wallet;

import com.cool_company.easy_bank.dto.wallet.WalletRespDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "Контроллер для работы с кошельками")
public interface WalletController {

    @Operation(summary = """
            Добавление нового кошелька""",
            description = "Позволяет добавить новый кошелек")
    ResponseEntity<WalletRespDto> addNewWallet();


    @Operation(summary = """
            Получить баланс""",
            description = "Позволяет получить значение баланса счета")
    ResponseEntity<WalletRespDto> getTotalAmount(@PathVariable UUID walletId);

}
