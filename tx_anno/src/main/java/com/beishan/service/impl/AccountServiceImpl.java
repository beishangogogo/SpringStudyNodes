package com.beishan.service.impl;

import com.beishan.dao.IAccountDao;
import com.beishan.domain.Account;
import com.beishan.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
//        1.根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
//        2.根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
//        3.转出账户减钱
        source.setMoney(source.getMoney() - money);
//        4.转入账户加钱
        target.setMoney(target.getMoney() + money);
//        5.更新转出账户
        accountDao.updateAccount(source);

//        int i = 10 / 0;

//        6.更新转入账户
        accountDao.updateAccount(target);
    }
}
