package com.beishan.dao;

import com.beishan.domain.Account;

import java.util.List;

public interface IAccountDao {

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

    /**
     * 根据名称查询账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回，如果没有结果就返回Null
     *          如果结果集超过一个就抛出异常
     */
    Account findAccountByName(String accountName);
}
