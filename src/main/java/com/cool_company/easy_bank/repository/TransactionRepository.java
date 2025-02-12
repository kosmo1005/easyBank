package com.cool_company.easy_bank.repository;


import com.cool_company.easy_bank.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
