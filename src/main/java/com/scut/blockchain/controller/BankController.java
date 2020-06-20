package com.scut.blockchain.controller;

import com.scut.blockchain.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    private BankService bankService;

    //在aspect设置了切点后，private会注入失败？？？
    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }


    //进行Object封装是为了能跟Aspect返回增强的类型一致，又不与原本接口的返回类型产生语法错误
    @GetMapping("/companyInfo")
    public Object getAllCompanies(){
        return bankService.getAllCompanies();
    }

    @PostMapping("/deliverPoints")
    public void deliverPoints(Long companyId, Integer pointsAmount) throws Exception{
        bankService.deliverPoints(companyId, pointsAmount);
    }

    @PostMapping("/acceptPoints")
    public void acceptPoints(Long companyId, Integer pointsAmount) throws Exception{
        bankService.acceptPoints(companyId, pointsAmount);
    }
}
