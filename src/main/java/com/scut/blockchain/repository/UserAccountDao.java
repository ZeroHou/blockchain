package com.scut.blockchain.repository;

import com.scut.blockchain.model.UserAccount;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserAccountDao extends Mapper<UserAccount> {

}
