package com.daliy.gof.Strategy;

import java.math.BigDecimal;

/**
 * @author Lenovo
 * @date 2020/7/25 15:08
 */
public class NineDiscount implements Discount {
    @Override
    public BigDecimal doDiscount(Double sourcePrice) {
        final BigDecimal source = new BigDecimal(sourcePrice.toString());
        final BigDecimal nineDis = new BigDecimal("0.9");
        return source.multiply(nineDis);
    }
}
