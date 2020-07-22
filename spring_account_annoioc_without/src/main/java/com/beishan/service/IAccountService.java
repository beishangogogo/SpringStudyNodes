package com.beishan.service;

import com.beishan.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存一个账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除一个账户
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
