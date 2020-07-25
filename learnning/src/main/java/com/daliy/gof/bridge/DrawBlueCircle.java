package com.daliy.gof.bridge;

/**
 * @author Lenovo
 * @date 2020/7/4 20:52
 */
public class DrawBlueCircle implements DrawAPI{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("draw blue circle,radius:"
                + radius + ",x:" + x + ",y:" + y);
    }
}
