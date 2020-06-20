package com.scut.blockchain.service;

import com.scut.blockchain.exception.UserPointsException;
import com.scut.blockchain.model.Company;
import com.scut.blockchain.model.User;
import com.scut.blockchain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    private BankService bankService;
//    @Autowired
//    private ContractService contractService;

    private CompanyService companyService;

    @Autowired
    private UserService(UserDao userDao, BankService bankService, CompanyService companyService) {
        this.userDao = userDao;
        this.bankService = bankService;
        this.companyService = companyService;
    }

    public void getPoints(Long userId, Long companyId, Integer pointsAmount) {
//        contractService.getPoints(userId, companyId, pointsAmount);
        companyService.cutHoldingPointsByUser(companyId, pointsAmount);
        User user = userDao.selectByPrimaryKey(userId);
        user.setPoints(user.getPoints() + pointsAmount);
        userDao.updateByPrimaryKeySelective(user);
    }

    public void giveAwayPoints(Long userId, Long toUserId, Integer pointsAmount) throws Exception {
//        contractService.giveAwayPoints(userId, toUserId, pointsAmount);
        User user = userDao.selectByPrimaryKey(userId);
        Integer holdingPoints = user.getPoints();
        if (holdingPoints - pointsAmount < 0)
            throw new UserPointsException();
        else {
            user.setPoints(holdingPoints - pointsAmount);
            User toUser = userDao.selectByPrimaryKey(toUserId);
            toUser.setPoints(toUser.getPoints() + pointsAmount);
            userDao.updateByPrimaryKeySelective(user);
            userDao.updateByPrimaryKeySelective(toUser);
        }
    }

    public List<Company> getAllCompanyInfo() {
        return bankService.getAllCompanies();
    }

    public void usePoints(Long userId, Long companyId, Integer pointsAmount) throws Exception {
//      contractService.usePoints(userId, companyId, pointsAmount);
        companyService.addHoldingPointsByUser(companyId, pointsAmount);
        User user = userDao.selectByPrimaryKey(userId);
        Integer holdingPoints = user.getPoints();
        if (holdingPoints - pointsAmount < 0)
            throw new UserPointsException();
        else {
            user.setPoints(holdingPoints - pointsAmount);
            userDao.updateByPrimaryKeySelective(user);
        }
    }

    User getUser(Long userId) {
        return userDao.selectByPrimaryKey(userId);
    }

//    void addUser(String name) throws Exception {
//        User user = contractService.addUser(name);
//        userDao.insert(user);
//    }
}
