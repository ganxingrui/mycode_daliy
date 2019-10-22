package com.daliy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gxr
 * @date 2019/10/17 21:48
 * 有一个传菜口，最多放一盘菜，放满了就崔服务员端走，然后才能继续放；
 * 同理如果没有菜，服务员则崔厨师抓紧做饭。顾客点了10盘菜。
 * 线程    操作   资源类
 */
public class ProdConsumerTraditionDemo {
	public static void main(String[] args) {
		final TransferTable transferTable = new TransferTable();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				transferTable.putFood();
			}
		},"厨师").start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				transferTable.getFood();
			}
		},"服务员").start();
	}
}

/**
 * 传菜口
 */
class TransferTable{
	int currentNum = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void putFood() {
		lock.lock();
		try {
			//一定是while判断防止虚假唤醒
			while (currentNum != 0){
				condition.await();
			}
			currentNum++;
			System.out.println(Thread.currentThread().getName()+"放了一盘菜");
			condition.signalAll();
		}catch (Exception e){
		    e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void getFood() {
		lock.lock();
		try {
			while (currentNum != 1){
				condition.await();
			}
			currentNum--;
			System.out.println(Thread.currentThread().getName()+"端走一盘菜");
			condition.signalAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
