package com.scut.blockchain.service;

import com.scut.blockchain.exception.CompanyPointsException;
import com.scut.blockchain.model.Company;
import com.scut.blockchain.repository.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyService {

    private CompanyDao companyDao;
//
//    @Autowired
//    private ContractService contractService;

    @Autowired
    private CompanyService(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    //包装类传参用的是封装类型：优点是防止基本类型接受空值或null的错误，缺点是数据传入封装需要耗时（小项目可忽略）。
    public void cutHoldingPointsByBank(Long companyId, Integer pointsAmount) throws CompanyPointsException {
        Company company = companyDao.selectByPrimaryKey(companyId);
        company.setHoldingPoints(company.getHoldingPoints() - pointsAmount);
        company.setDeliveredPoints(company.getDeliveredPoints() - pointsAmount);
        companyDao.updateByPrimaryKeySelective(company);
    }

    public void cutHoldingPointsByUser(Long companyId, Integer pointsAmount) throws CompanyPointsException {
        Company company = companyDao.selectByPrimaryKey(companyId);
        company.setHoldingPoints(company.getHoldingPoints() - pointsAmount);
        companyDao.updateByPrimaryKeySelective(company);
    }

    public void addHoldingPointsByBank(Long companyId, Integer pointsAmount) {
        Company company = companyDao.selectByPrimaryKey(companyId);
        company.setHoldingPoints(company.getHoldingPoints() + pointsAmount);
        company.setDeliveredPoints(company.getDeliveredPoints() + pointsAmount);
        companyDao.updateByPrimaryKeySelective(company);
    }

    public void addHoldingPointsByUser(Long companyId, Integer pointsAmount) {
        Company company = companyDao.selectByPrimaryKey(companyId);
        company.setHoldingPoints(company.getHoldingPoints() + pointsAmount);
        companyDao.updateByPrimaryKeySelective(company);
    }

    public List<Company> getAllCompanies(){
        return companyDao.selectAll();
    }

    public Company getCompany(Long companyId) {
        return companyDao.selectByPrimaryKey(companyId);
    }

//    void addCompany(String name) throws Exception {
//        Company company = contractService.addCompany(name);
//        companyDao.insert(company);
//    }
}
