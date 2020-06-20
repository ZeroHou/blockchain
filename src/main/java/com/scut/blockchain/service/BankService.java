package com.scut.blockchain.service;

import com.scut.blockchain.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    private CompanyService companyService;
//    @Autowired
//    private ContractService contractService;

//    private BankDao bankDao;

    @Autowired
    private BankService(CompanyService companyService){
        this.companyService = companyService;
//        this.bankDao = bankDao;
    }

    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    public void deliverPoints(Long companyId, Integer pointsAmount) throws Exception {
//        contractService.deliverPoints(companyId, pointsAmount);
        companyService.addHoldingPointsByBank(companyId, pointsAmount);
    }

    public void acceptPoints(Long companyId, Integer pointsAmount) throws Exception {
//        contractService.acceptPoints(companyId, pointsAmount);
        companyService.cutHoldingPointsByBank(companyId, pointsAmount);
    }

//    void addBank(String privateKey, String contractAddress) {
//        Bank bank = new Bank();
//        bank.setPrivateKey(privateKey);
//        bank.setContractAddress(contractAddress);
//        bank.setDeliveredPoints(0);
//        bankDao.insert(bank);
//    }

//    Bank getBank() {
//        List<Bank> bankList = bankDao.selectAll();
//        return bankList.get(0);
//    }
}
