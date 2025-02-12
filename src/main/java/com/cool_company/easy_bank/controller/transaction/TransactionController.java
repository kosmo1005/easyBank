package com.cool_company.easy_bank.controller.transaction;

import com.cool_company.easy_bank.dto.transaction.TransactionReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Контроллер для проведения транзакций")
public interface TransactionController {

    @Operation(summary = """
            Провести операцию""",
            description = "Проводит операцию пополнения или списания средств")
    ResponseEntity<Void> processTransaction(@RequestBody TransactionReqDto dto);
}
