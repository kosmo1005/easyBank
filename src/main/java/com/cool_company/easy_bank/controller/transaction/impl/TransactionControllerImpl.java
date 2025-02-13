package com.cool_company.easy_bank.controller.transaction.impl;

import com.cool_company.easy_bank.controller.transaction.TransactionController;
import com.cool_company.easy_bank.dto.transaction.TransactionReqDto;
import com.cool_company.easy_bank.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
@Validated
public class TransactionControllerImpl implements TransactionController {

    private final TransactionService service;

    @PostMapping
    @Override
    public ResponseEntity<Void> processTransaction(@RequestBody @Valid TransactionReqDto dto) {
        service.processTransaction(dto);
        return ResponseEntity.ok().build();
    }
}
