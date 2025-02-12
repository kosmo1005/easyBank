package com.cool_company.easy_bank.service;

import com.cool_company.easy_bank.dto.wallet.WalletRespDto;
import com.cool_company.easy_bank.entity.WalletEntity;
import com.cool_company.easy_bank.exceptions.WalletNotFoundException;
import com.cool_company.easy_bank.repository.WalletRepository;
import com.cool_company.easy_bank.transformers.WalletTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository repo;
    private final WalletTransformer t;

    @Transactional
    public WalletRespDto addNewWallet() {
        var entity = new WalletEntity();
        var savedEntity = repo.save(entity);
        return t.entityToDto(savedEntity);
    }

    @Transactional
    public WalletRespDto getTotalAmount(UUID id) {
        var entity = repo.findById(id).orElseThrow(WalletNotFoundException::new);
        return t.entityToDto(entity);
    }

    @Transactional
    protected WalletEntity getWalletById(UUID id) {
        return repo.findById(id).orElseThrow(WalletNotFoundException::new);
    }

    @Transactional
    protected void updateWalletAmount(WalletEntity updatedWallet) {
        repo.save(updatedWallet);
    }
}