package com.daliy.gof.prototype;

/**
 * @author Lenovo
 * @date 2020/7/4 19:29
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    public void draw(){
        System.out.println("draw circle");
    }
}
