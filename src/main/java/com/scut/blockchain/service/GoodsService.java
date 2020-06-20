package com.scut.blockchain.service;

import com.scut.blockchain.model.Goods;
import com.scut.blockchain.repository.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    private GoodsDao goodsDao;

    @Autowired
    public GoodsService(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void delGoods(Long companyId, Long goodsId) {
        goodsDao.deleteByPrimaryKeyWithCompanyId(companyId, goodsId);
    }

    public List<Goods> getAllGoods(Long companyId) {
        return goodsDao.selectAllByCompanyId(companyId);
    }

    public Long posGoods(Long companyId, String name, Integer pointsBonus) {
        Goods goods = new Goods();
        goods.setter(companyId, name, pointsBonus);
        goodsDao.insertSelective(goods);
        return goods.getId();
    }
}
