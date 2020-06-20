package com.scut.blockchain.repository;


import com.scut.blockchain.model.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface CompanyDao extends Mapper<Company> {

    Company selectOneByAccount(@Param("account") String account);
}
