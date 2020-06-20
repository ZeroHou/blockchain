package com.scut.blockchain.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "gift")
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;

    private String name;

    private Integer pointsPrice;

    public void setter(Long companyId, String name, Integer pointsPrice) {
        this.companyId = companyId;
        this.name = name;
        this.pointsPrice = pointsPrice;
    }

    //通过构造器传参会出现调用gift的mapper出现问题，前端500错误，但后端没有如何错误日志(对posGift不影响)？？？(也可以多写一个空的构造函数解决问题)
//    public Gift(Long companyId, String name, Integer pointsBonus) {
//        this.companyId = companyId;
//        this.name = name;
//        this.pointsBonus = pointsBonus;
//    }
}
