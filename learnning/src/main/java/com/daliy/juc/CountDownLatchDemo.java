package com.daliy.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author gxr
 * @date 2019年10/12
 * A CountDownLatch is initialized with a given count.
 * The await methods block until the current count reaches zero
 * due to invocations of the countDown() method,
 * after which all waiting threads are released and any subsequent invocations of
 * await return immediately
 * 一个餐桌有10个人，等到所有人吃饱后，服务员收餐具。
 */
public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		int peopleNum = 5;
		final CountDownLatch countDownLatch = new CountDownLatch(peopleNum);
		for (int i=0; i<peopleNum; i++){
			new Thread(() -> {
				System.out.println("人员" + Thread.currentThread().getName()+"吃饱了");
				countDownLatch.countDown();
			},String.valueOf(i)).start();
		}
		countDownLatch.await();
		System.out.println("所有人吃饱之后，服务员收餐具。。。。");
	}
}
