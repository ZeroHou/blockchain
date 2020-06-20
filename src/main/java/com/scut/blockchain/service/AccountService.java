package com.scut.blockchain.service;

import com.scut.blockchain.exception.LoginException;
import com.scut.blockchain.model.*;
import com.scut.blockchain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class AccountService {

    UserAccountDao userAccountDao;

    UserDao userDao;

    CompanyAccountDao companyAccountDao;

    CompanyDao companyDao;

    BankAccountDao bankAccountDao;



    @Autowired
    private AccountService(UserAccountDao userAccountDao,
                           UserDao userDao,
                           CompanyAccountDao companyAccountDao,
                           CompanyDao companyDao,
                           BankAccountDao bankAccountDao) {
        this.userAccountDao = userAccountDao;
        this.userDao = userDao;
        this.companyAccountDao = companyAccountDao;
        this.companyDao = companyDao;
        this.bankAccountDao = bankAccountDao;
    }

    public void registerCompany(String account, String password, String name) {
        CompanyAccount companyAccount = new CompanyAccount(account, password, name);
        Company company = new Company();
        company.setter(account, name);
        //todo:company.setPrivateKey(privateKey);
        companyAccountDao.insertSelective(companyAccount);
        companyDao.insertSelective(company);
    }

    public void registerUser(String account, String password, String name) throws Exception {
        UserAccount userAccount = new UserAccount(account, password, name);
        User user = new User();
        user.setter(account, name);
        //todo:company.setPrivateKey(privateKey);
        userAccountDao.insertSelective(userAccount);
        userDao.insertSelective(user);
    }

    public void registerBank(String account, String password, String name) {
        BankAccount bankAccount = new BankAccount(account, password, name);
        bankAccountDao.insertSelective(bankAccount);
    }

    public boolean loginBank(String account, String password) {
        BankAccount bankAccount = bankAccountDao.selectByPrimaryKey(account);
        if (bankAccount == null)
            throw new LoginException();
        else {
            if (password.equals(bankAccount.getPassword())) {
                throw new LoginException();
            }
        }
        return true;
    }

    //LinkedHashMap可以顺序输出，HashMap不可以
    public LinkedHashMap<String, Object> loginCompany(String account, String password) {
        CompanyAccount companyAccount = companyAccountDao.selectByPrimaryKey(account);
        Company company = companyDao.selectOneByAccount(account);
        LinkedHashMap<String, Object> companyMap =new LinkedHashMap<>();
        if (password.equals(companyAccount.getPassword())) {
            companyMap.put("id", company.getId());
            companyMap.put("name", companyAccount.getName());
            companyMap.put("holding_points", company.getHoldingPoints());
            companyMap.put("delivered_points", company.getDeliveredPoints());
        }
        return companyMap;
    }

    public LinkedHashMap<String, Object> loginUser(String account, String password) {
        UserAccount userAccount = userAccountDao.selectByPrimaryKey(account);
        User user = userDao.selectOneByAccount(account);
        LinkedHashMap<String, Object> userMap =new LinkedHashMap<>();
        if (password.equals(userAccount.getPassword())) {
            userMap.put("id", user.getId());
            userMap.put("name", userAccount.getName());
            userMap.put("points", user.getPoints());
        }
        return userMap;
    }
}
