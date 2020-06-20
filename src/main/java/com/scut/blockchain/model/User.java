package com.scut.blockchain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String name;

    private Integer points = 0;

    private String privateKey;

    public void setter(String account, String name) {
        this.account = account;
        this.name = name;
    }
}
