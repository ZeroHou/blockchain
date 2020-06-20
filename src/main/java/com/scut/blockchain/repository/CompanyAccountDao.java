package com.scut.blockchain.repository;

import com.scut.blockchain.model.CompanyAccount;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CompanyAccountDao extends Mapper<CompanyAccount> {

}
