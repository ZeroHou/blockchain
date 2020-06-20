package com.scut.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user_account")
@AllArgsConstructor
public class UserAccount {

    @Id
    private String account;

    private String password;

    private String name;
}
