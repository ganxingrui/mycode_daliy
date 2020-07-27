package com.daliy.gof.Strategy;

import java.math.BigDecimal;

/**
 * @author Lenovo
 * @date 2020/7/25 15:08
 */
public class NineDiscount implements Discount {
    @Override
    public BigDecimal doDiscount(Double sourcePrice) {
        /**
         * 使用BigDecimal的坑
         * 阿里巴巴开发手册，P21,第10条，强调不要使用BigDecimal(double)的方式，
         * 存在精度损失风险。
         * 推荐以下两种方式：
         * BigDecimal good1 = new BigDecimal("0.1");
         * BigDecimal good2 = BigDecimal.valueOf(0.1);
         */
        final BigDecimal source = new BigDecimal(sourcePrice.toString());
        final BigDecimal nineDis = new BigDecimal("0.9");

        return source.multiply(nineDis);
    }
}
