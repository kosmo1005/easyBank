package com.cool_company.easy_bank.service;


import com.cool_company.easy_bank.dto.transaction.TransactionReqDto;
import com.cool_company.easy_bank.repository.TransactionRepository;
import com.cool_company.easy_bank.transformers.TransactionTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repo;
    private final TransactionTransformer t;
    private final WalletService walletService;

    @Transactional
    public void processTransaction(TransactionReqDto dto) {
        var wallet = walletService.getWalletById(dto.walletId());

        switch (dto.operationType()) {
            case DEPOSIT -> {
                repo.save(t.dtoToEntity(dto));

                wallet.setTotalAmount(wallet.getTotalAmount().add(dto.amount()));
                walletService.updateWalletAmount(wallet);
            }
            case WITHDRAW -> {
                if (dto.amount().compareTo(wallet.getTotalAmount()) < 0) {
                    repo.save(t.dtoToEntity(dto));

                    wallet.setTotalAmount(wallet.getTotalAmount().subtract(dto.amount()));
                    walletService.updateWalletAmount(wallet);
                } else {
                    throw new IllegalArgumentException("Amount must be greater than or equal to the wallet total amount");
                }
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + dto.operationType());
        }
    }

}
