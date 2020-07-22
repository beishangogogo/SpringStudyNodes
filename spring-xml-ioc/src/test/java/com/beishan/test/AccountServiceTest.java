package com.beishan.test;

import com.beishan.domain.Account;
import com.beishan.service.IAccountService;
import com.beishan.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {
//        1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
//        3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
//        1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
//        3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account newAccount = new Account();
        newAccount.setId((Integer) 4);
        newAccount.setName("test04");
        newAccount.setMoney((float) 100);
//        1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
//        3.执行方法
        as.saveAccount(newAccount);
    }

    @Test
    public void testUpdate() {
//        1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
//        3.执行方法
        Account account = as.findAccountById(3);
        account.setMoney((float)500);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
//        1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
//        3.执行方法
        int id = 1;
        as.deleteAccount(id);
    }
}

