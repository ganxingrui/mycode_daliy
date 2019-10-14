package com.daliy.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Lenovo
 * @date 2019/10/12 23:42
 * 场景：领导给10个人开会，等这10个人都到了之后，领导才出场。
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{
			System.out.println("所有人到齐，大领导才出场");
		});
		for (int i=0; i<10; i++){
			new Thread(() -> {
				System.out.println("第"+ Thread.currentThread().getName()+"号人到了。。。");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
	}
}
