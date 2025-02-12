package com.cool_company.easy_bank.transformers;

import com.cool_company.easy_bank.dto.transaction.TransactionReqDto;
import com.cool_company.easy_bank.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionTransformer {

    TransactionEntity dtoToEntity(TransactionReqDto dto);

}
