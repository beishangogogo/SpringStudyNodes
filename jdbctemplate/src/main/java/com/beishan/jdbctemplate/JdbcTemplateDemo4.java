package com.beishan.jdbctemplate;

import com.beishan.dao.IAccountDao;
import com.beishan.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTempLate的基本用法
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {

//        1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2、获取对象
        IAccountDao ad = (IAccountDao) ac.getBean("accountDao");
//        3、执行操作
        Account account = ad.findAccountById(1);
        System.out.println(account);
    }
}
