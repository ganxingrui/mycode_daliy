package com.daliy.gof.Strategy;

import java.math.BigDecimal;

/**
 * @author Lenovo
 * @date 2020/7/25 15:11
 */
public class Context {
    private Discount discount;

    public Context(Discount discount) {
        this.discount = discount;
    }

    public BigDecimal executeDiscount(Double price){
        return discount.doDiscount(price);
    }
}

















