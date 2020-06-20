package com.scut.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.scut.blockchain.repository")
public class BlockchainApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BlockchainApplication.class, args);
    }

}
