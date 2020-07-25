package com.daliy.gof.Strategy;

import java.math.BigDecimal;

/**
 * @author Lenovo
 * @date 2020/7/25 14:53
 */
public class SixDiscount implements Discount{

    @Override
    public BigDecimal doDiscount(Double sourcePrice) {
        final BigDecimal source = new BigDecimal(sourcePrice.toString());
        final BigDecimal sixDis = new BigDecimal("0.6");

        return source.multiply(sixDis);
    }
}
