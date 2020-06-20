package com.scut.blockchain.repository;

import com.scut.blockchain.model.Bank;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BankDao extends Mapper<Bank> {
}
