package com.daliy.gof.bridge;

/**
 * @author Lenovo
 * @date 2020/7/4 20:54
 */
public abstract class Shape {
    // 依赖接口，不依赖具体实现
    public DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
