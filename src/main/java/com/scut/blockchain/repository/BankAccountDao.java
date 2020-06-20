package com.scut.blockchain.repository;

import com.scut.blockchain.model.BankAccount;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BankAccountDao extends Mapper<BankAccount> {

}
