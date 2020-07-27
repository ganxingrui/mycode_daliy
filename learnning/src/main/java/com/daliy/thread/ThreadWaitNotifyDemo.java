package com.daliy.thread;

/**
 * @author Lenovo
 * @date 2020/7/27 22:01
 * 现在，两个线程，可以操作初始值为零的一个变量，实现一个线程对该变量加1，一个线程实现对
 * 该变量减1.实现交替，来10轮，变量的值为0
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        final operNum operNum = new operNum();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                operNum.add();
            }
        },"操作1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                operNum.sub();
            }
        },"操作2").start();
    }

}

class operNum{
    int num = 0;

    public synchronized void add(){
        try {
            if (num == 0){
                num++;
                System.out.println(Thread.currentThread().getName()+":"+num);
                this.notifyAll();
            }else {
                this.notifyAll();
                this.wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public synchronized void sub(){
        try {
            if (num != 0){
                num--;
                System.out.println(Thread.currentThread().getName()+":"+num);
                this.notifyAll();
            }else {
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }

    }
}


