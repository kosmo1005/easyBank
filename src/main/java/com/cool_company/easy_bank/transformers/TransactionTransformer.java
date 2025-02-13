package com.cool_company.easy_bank.transformers;

import com.cool_company.easy_bank.dto.transaction.TransactionReqDto;
import com.cool_company.easy_bank.entity.TransactionEntity;
import com.cool_company.easy_bank.entity.WalletEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TransactionTransformer {

     default TransactionEntity dtoToEntity(WalletEntity wallet, TransactionReqDto dto) {
        if ( wallet == null || dto == null ) {
            return null;
        }

        TransactionEntity entity = new TransactionEntity();
        entity.setWallet(wallet);
        entity.setOperationType(dto.operationType());
        entity.setAmount(dto.amount());
        return entity;
    }

}
