package com.daliy.leetcode;

import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 * @date 2020/7/1 22:40
 */
public class dizhi2 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                synchronized (String.class){
                    System.out.println(Thread.currentThread().getName()+"进入锁。。。。" + dizhi.class.toString());
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
