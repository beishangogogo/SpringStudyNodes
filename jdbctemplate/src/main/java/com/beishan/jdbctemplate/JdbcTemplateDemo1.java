package com.beishan.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTempLate的基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
//        准备数据源：spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/beishan01");
        ds.setUsername("beishan");
        ds.setPassword("Database_9527");

//        1、创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate(ds);
//        2、执行操作
        jt.execute("insert into account(name,money)value('ccc',1000)");
    }
}
