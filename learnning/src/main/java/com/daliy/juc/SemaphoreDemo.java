package com.daliy.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author gxr
 * @date 2019/10/13 23:20
 * semaphore针对多个线程抢多个资源，现实类似停车场。
 * 举例：10辆车，抢3个车位。
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(3);
		for (int i=0; i<10; i++){
			new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+"抢到车位");
					TimeUnit.SECONDS.sleep(5);
					System.out.println(Thread.currentThread().getName()+"停车5秒后离开");
					semaphore.release();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
	}
}
