package com.scut.blockchain.service;

import com.scut.blockchain.model.Gift;
import com.scut.blockchain.repository.GiftDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    private GiftDao giftDao;

    @Autowired
    private GiftService(GiftDao giftDao) {
        this.giftDao = giftDao;
    }

    public void delGift(Long companyId, Long giftId) {
        giftDao.deleteByPrimaryKeyWithCompanyId(companyId, giftId);
    }

    public List<Gift> getAllGifts(Long companyId)  {
        return giftDao.selectAllByCompanyId(companyId);
    }

    public void posGift(Long companyId, String name, Integer pointsPrice) {
        Gift gift = new Gift();
        gift.setter(companyId, name, pointsPrice);
        //insertSelective只处理不为null的字段,insert都处理
        giftDao.insertSelective(gift);
    }
}
