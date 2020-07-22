package com.beishan.proxy;

public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProducer(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
