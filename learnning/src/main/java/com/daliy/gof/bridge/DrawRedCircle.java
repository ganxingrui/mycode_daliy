package com.daliy.gof.bridge;

/**
 * @author Lenovo
 * @date 2020/7/4 20:51
 */
public class DrawRedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("draw red circle,radius:" + radius + ",x:"
                + ",y:" + y);

    }
}
