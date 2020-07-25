package com.daliy.gof;

/**
 * @author Lenovo
 * @date 2020/6/27 11:25
 * 单例模式
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    // DCL  双检锁
    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
