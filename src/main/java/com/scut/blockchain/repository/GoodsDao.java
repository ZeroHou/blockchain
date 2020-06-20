package com.scut.blockchain.repository;

import com.scut.blockchain.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface GoodsDao extends Mapper<Goods> {

    void deleteByPrimaryKeyWithCompanyId(@Param("companyId") Long companyId, @Param("goodsId") Long goodsId);

    List<Goods> selectAllByCompanyId(@Param("companyId") Long companyId);
}
