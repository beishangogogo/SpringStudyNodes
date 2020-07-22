package com.beishan.factory;

import com.beishan.service.IAccountService;
import com.beishan.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
