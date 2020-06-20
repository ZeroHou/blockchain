package com.scut.blockchain.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //1、数据类型都是类，比如Long不能是long，否则会出错。在数据库id是bigint，只要Long的范围能覆盖就行(long 64位，bigint 64位)
    //2、注意属性名称的默认转换，holdingPoints在mysql会自动转换成holding_points
    private Long id;

    private String account;

    private String name;
    //@JsonIgnore
    private Integer holdingPoints = 0;
    //@JsonIgnore
    private Integer deliveredPoints = 0;

    private String privateKey;

    public void setter(String account, String name) {
        this.account = account;
        this.name = name;
    }
}

