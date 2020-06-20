package com.scut.blockchain.controller;

import com.scut.blockchain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private AccountService accountService;

    @Autowired
    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/bank")
    public Object loginBank(@RequestParam("account") String account, @RequestParam("password") String password)  {
        return accountService.loginBank(account, password);
    }

    @GetMapping("/company")
    public Object loginCompany(@RequestParam("account") String account, @RequestParam("password") String password) {
        return accountService.loginCompany(account, password);
    }

    @GetMapping("/user")
    public Object loginUser(@RequestParam("account") String account, @RequestParam("password") String password) {
        return accountService.loginUser(account, password);
    }
}
