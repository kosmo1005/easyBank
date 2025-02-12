package com.cool_company.easy_bank.controller.wallet.impl;

import com.cool_company.easy_bank.controller.wallet.WalletController;
import com.cool_company.easy_bank.dto.wallet.WalletRespDto;
import com.cool_company.easy_bank.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallet")
public class WalletControllerImpl implements WalletController {

    private final WalletService service;

    @PostMapping
    @Override
    public ResponseEntity<WalletRespDto> addNewWallet() {
        return ResponseEntity.ok(service.addNewWallet());
    }

    @GetMapping("/{walletId}")
    @Override
    public ResponseEntity<WalletRespDto> getTotalAmount(@PathVariable UUID walletId) {
        return ResponseEntity.ok(service.getTotalAmount(walletId));
    }
}
