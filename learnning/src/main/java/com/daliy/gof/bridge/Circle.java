package com.daliy.gof.bridge;

/**
 * @author Lenovo
 * @date 2020/7/4 20:56
 */
public class Circle extends Shape{
    // 类属性，数据类型采用包装类  阿里巴巴开发手册，并且每行一个属性
    private Integer radius;
    private Integer x;
    private Integer y;

    public Circle(DrawAPI drawAPI, Integer radius, Integer x, Integer y) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
