package com.daliy.gof.Strategy;

import java.math.BigDecimal;

public interface Discount {
    public BigDecimal doDiscount(Double sourcePrice);
}
