package com.daliy.gof.prototype;

/**
 * @author Lenovo
 * @date 2020/7/4 19:37
 */
public class Square extends Shape{
    public Square() {
        type = "squre";
    }

    public void draw(){
        System.out.println("draw square");
    }
}
