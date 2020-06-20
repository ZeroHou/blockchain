package com.scut.blockchain.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //外键
    private String account;

    private Integer deliveredPoints = 0;

    private String privateKey;

    private String contractAddress;
}
