package com.daliy.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lenovo
 * @date 2019/10/22 23:09
 * 对比synchronized与lock的区别？lock有什么优点？
 * 1、synchronized是jvm级别，通过monitorenter、monitorexit保证原子性,不可中断
 * lock是api级别,可以被中断*****
 * 2、使用方式不同，synchronized会自己释放锁，可以夹在方法上，或代码块
 * lock需要lock(),unlock(),必须手动释放锁。
 * 3、synchronized是非公平锁
 * lock默认是非公平锁（false），当传true时，是公平锁
 * 4、lock可以绑定condition,实现条件唤醒  ******
 */
public class SynchronizeAndLock {
	public static void main(String[] args) {
		synchronized (new Object()){

		}

		final ReentrantLock lock = new ReentrantLock();
	}
}
