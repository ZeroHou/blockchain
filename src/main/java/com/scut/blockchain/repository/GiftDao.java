package com.scut.blockchain.repository;

import com.scut.blockchain.model.Gift;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface GiftDao extends Mapper<Gift> {

    //interface的方法强制为public，方便实现
    void deleteByPrimaryKeyWithCompanyId(@Param("companyId") Long companyId, @Param("giftId") Long giftId);

    List<Gift> selectAllByCompanyId(@Param("companyId") Long companyId);
}
