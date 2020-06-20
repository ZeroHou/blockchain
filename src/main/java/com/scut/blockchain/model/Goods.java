package com.scut.blockchain.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;

    private String name;

    private Integer pointsBonus;

    public void setter(Long companyId, String name, Integer pointsBonus) {
        this.companyId = companyId;
        this.name = name;
        this.pointsBonus = pointsBonus;
    }
}

