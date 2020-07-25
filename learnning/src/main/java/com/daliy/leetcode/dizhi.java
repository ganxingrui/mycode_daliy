package com.daliy.leetcode;

import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 * @date 2020/7/1 21:50
 */
public class dizhi {
    public static void main(String[] args) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000*30);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        synchronized (String.class){
            System.out.println(Thread.currentThread().getName()+"进入锁。。。。" + dizhi.class.toString());
            try {
            	TimeUnit.MILLISECONDS.sleep(1000*30);
            } catch (InterruptedException e)
            {
            	e.printStackTrace();
            }
            System.out.println("释放锁。。。");
        }
        new Thread(){
            @Override
            public void run() {
                super.run();
                synchronized (String.class){
                    System.out.println(Thread.currentThread().getName()+"进入锁。。。。" + dizhi.class.toString());
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000*30);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println("释放锁。。。");
                }
            }
        }.start();
    }
}
