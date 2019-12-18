package com.daliy.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 * @date 2019/12/17 22:20
 */
public class DeadLockDemo {

	public static void main(String[] args) {
		String LockA="LOCKA";
		String LockB="LOCKB";
		new Thread(()->{
			synchronized (LockA){
				try {
					TimeUnit.MILLISECONDS.sleep(300);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (LockB){
					System.out.println("A在工作。。。。");
				}
			}
		}).start();
		//两个线程获取锁的顺序相反，双方各自持有对方需要的锁
		new Thread(()->{
			synchronized (LockB){
				try {
					TimeUnit.MILLISECONDS.sleep(300);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (LockA){
					System.out.println("B在工作。。。。");
				}
			}
		}).start();
		/**
		 * 运行结果：不打印，并持续等待下去。
		 * 问题分析：
		 * 1、jsp -l  查看当前java正在运行的进程，找到自己编写的。
		 * 2、jstack  进程号
		 */
	}
}

