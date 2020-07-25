package com.daliy.gof.prototype;

/**
 * @author Lenovo
 * @date 2020/7/4 19:52
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        final Shape cloneShape = ShapeCache.getShapeByID("1");
        System.out.println("Shape:" + cloneShape.getType());

        final Shape cloneShape2 = ShapeCache.getShapeByID("2");
        System.out.println("Shape:" + cloneShape2.getType());

        final Shape cloneShape3 = ShapeCache.getShapeByID("3");
        System.out.println("Shape" + cloneShape3.getType());

    }
}
