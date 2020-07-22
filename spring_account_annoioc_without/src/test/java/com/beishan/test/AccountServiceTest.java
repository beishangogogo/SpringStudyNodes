package com.beishan.test;

import com.beishan.domain.Account;
import com.beishan.service.IAccountService;
import com.beishan.service.impl.AccountServiceImpl;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar（坐标）
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *          @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *              locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在位置
 *
 *    当我们使用spring 5.x 版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    private ApplicationContext ac;
    private IAccountService as;

    @Before
    public void init() {
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        as = ac.getBean("accountService", IAccountService.class);
    }

    @Test
    public void testFindAll() {
//        1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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

