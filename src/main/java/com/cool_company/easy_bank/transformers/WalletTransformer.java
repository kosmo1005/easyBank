package com.cool_company.easy_bank.transformers;

import com.cool_company.easy_bank.dto.wallet.WalletRespDto;
import com.cool_company.easy_bank.entity.WalletEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface WalletTransformer {

    WalletRespDto entityToDto(WalletEntity entity);
}
