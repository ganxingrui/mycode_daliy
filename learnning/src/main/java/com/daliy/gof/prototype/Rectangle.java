package com.daliy.gof.prototype;

/**
 * @author Lenovo
 * @date 2020/7/4 19:34
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    public void draw(){
        System.out.println("draw rectangle");
    }
}
