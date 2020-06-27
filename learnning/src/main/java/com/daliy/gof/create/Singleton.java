package com.daliy.gof.create;

/**
 * @author Lenovo
 * @date 2020/6/27 11:25
 * 单例模式
 */
public class Singleton {
    //第二步：准备一个变量放该单例对象
    private static Singleton singleton;
    //第一步：构造器私有化,避免外面创建对象
    private Singleton() {
    }

    //第三步：提供对外访问的方法,由于外部还没有对象，所以是静态方法
    /*public static synchronized Singleton getSingleton(){
        if (singleton == null){
            return new Singleton();
        }
        return singleton;
    }*/

    // DCL  双检锁
    public static Singleton getSingleton(){
        // 此时无论有没有创建对象，都先获取同步锁,当实例存在时，
        // 不在进入同步代码块，直接返回实例
        if(singleton == null){
            synchronized (Singleton.class){
                //让判断和创建，作为一个原子操作
                if (singleton == null){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}
