package com.daliy.gof.bridge;

/**
 * @author Lenovo
 * @date 2020/7/4 21:11
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        final Circle redCircle = new Circle(new DrawRedCircle(), 1, 5, 5);
        final Circle blueCircle = new Circle(new DrawBlueCircle(), 10, 3, 5);

        redCircle.draw();
        blueCircle.draw();

    }
}
