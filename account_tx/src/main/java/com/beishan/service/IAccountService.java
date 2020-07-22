package com.beishan.service;

import com.beishan.domain.Account;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     *
     * @param sourceName    转出账户
     * @param targetName    转入账户
     * @param money         金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
