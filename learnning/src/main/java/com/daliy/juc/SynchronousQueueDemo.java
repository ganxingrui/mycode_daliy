package com.daliy.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 * @date 2019/10/15 23:32
 * SynchronousQueue放一个元素后，如果不取出该元素，则不能存放下一个。
 */
public class SynchronousQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+"1");
			try {
				blockingQueue.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"2");
			try {
				blockingQueue.put(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"3");
			try {
				blockingQueue.put(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"添加").start();

		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println(Thread.currentThread().getName()+blockingQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println(Thread.currentThread().getName()+blockingQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println(Thread.currentThread().getName()+blockingQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"取出").start();
	}
}
