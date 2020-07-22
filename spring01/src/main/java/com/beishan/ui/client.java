package com.beishan.ui;

import com.beishan.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class client {

    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext接口三个实现类：
     *      ClassPathXmlApplicationContext: 加载类下对的配置文件
     *      FilePathXmlApplication: 可以加载任意路径下的配置文件
     *      AnnotationConfigApplication: 用于读取注解创建容器
     * 核心容器的两个接口引发的问题：
     *  BeanFactory:    （多例对象适用）
     *      在构建核心容器时，创建对象采取的策略是采用延时加载的方式，什么时候通过id获取对象了，什么时候真正创建对象
     *  ApplicationContext: （单例对象适用）
     *      在构建核心容器时，创建对象采取的是立即加载的策略，一读完配置文件立马创建对象
     * @param args
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService as1 = (IAccountService) ac.getBean("accountService");

 }
}
