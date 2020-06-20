package com.scut.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/*
    帐号密码和其他信息分表存储：
    1、面向对象方面考虑
    用户信息就是用户本身，用户名和密码只是登陆钥匙
    2、性能方面考虑
    登陆验证的时候列较少，查询速度快。
    、3安全性考虑
    防止在查询用户信息时，把密码也直接查询出来，会容易被攻击和进行恶意操作。
*/
@Data
@Table(name = "bank_account")
@AllArgsConstructor
public class BankAccount {

    @Id
    private String account;

    private String password;

    private String name;
}
