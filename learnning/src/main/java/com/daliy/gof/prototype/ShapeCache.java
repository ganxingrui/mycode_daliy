package com.daliy.gof.prototype;

import java.util.Hashtable;

/**
 * @author Lenovo
 * @date 2020/7/4 19:44
 */
public class ShapeCache {

    private static Hashtable<String,Shape> shapeCache = new Hashtable<>();

    public static Shape getShapeByID(String ID){
        final Shape shape = shapeCache.get(ID);
        return (Shape) shape.clone();
    }

    //模拟从数据库加载数据后，生成对象
    public static void loadCache(){
        final Circle circle = new Circle();
        circle.setId("1");
        shapeCache.put(circle.getId(),circle);

        final Square square = new Square();
        square.setId("2");
        shapeCache.put(square.getId(),square);

        final Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeCache.put(rectangle.getId(),square);
    }
}
