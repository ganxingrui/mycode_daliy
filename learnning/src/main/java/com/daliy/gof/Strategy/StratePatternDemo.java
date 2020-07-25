package com.daliy.gof.Strategy;

/**
 * @author Lenovo
 * @date 2020/7/25 15:14
 */
public class StratePatternDemo {
    public static void main(String[] args) {
        double goodsPrice = 100;
        final Context context = new Context(new SixDiscount());

        System.out.println("原价：" + goodsPrice);
        System.out.println("6折后：" + context.executeDiscount(goodsPrice).toString());

        final Context context9 = new Context(new NineDiscount());
        System.out.println("9折后：" + context9.executeDiscount(goodsPrice).toString());



    }
}
