package com.scut.blockchain.controller;

import com.scut.blockchain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    AccountService accountService;

    @Autowired
    public RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/company")
    public void registerCompany(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("name") String name) {
        accountService.registerCompany(account, password, name);
    }

    @PostMapping("/user")
    public void registerUser(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("name") String name) throws Exception {
        accountService.registerUser(account, password, name);
    }
}
