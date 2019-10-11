package com.daliytest.juctest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  @author gxr
 *  @date 2019年10月10号
 *  学习读写锁，测试写锁是独占锁，读锁是共享锁。
 *  写写线程，不共享锁；写读，不共享；读读，共享。
 *
 *  下面模拟操作缓存，写缓存要求独占写，读缓存共享。
 */
public class ReadWriteLockDemo {
	public static void main(String[] args) {
		MyCache myCache = new MyCache();
		// 创建5个线程进行写操作
		for (int i=0; i<5; i++){
			final int tempInt = i;
			new Thread(() -> {
				myCache.setCache(tempInt + "",tempInt);
			},String.valueOf(i)).start();
		}

		// 创建5个线程进行读操作
		for (int i=0; i<5; i++){
			final int tempInt = i;
			new Thread(() -> {
				myCache.getCache(tempInt + "");
			},String.valueOf(i)).start();
		}
	}
}

/**
 * 所谓缓存，其实就是维护一个map,基本操作就是写缓存，读取缓存，在附加清空等。
 * 设计时，注意缓存的更改要求可见性；而且写独占，读共享。单例的
 */
class MyCache{
	private volatile Map<String,Object> map = new HashMap<>();
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private Lock r = rwl.readLock();
	private Lock w = rwl.writeLock();

	/**
	 * @param key 键
	 * @param value 值
	 */
	public void setCache(String key,Object value){
		w.lock();
		try {
			System.out.println("线程："+Thread.currentThread().getName()+"开始写缓存。。。。");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			map.put(key,value);
			System.out.println("线程："+Thread.currentThread().getName()+"写缓存完毕。。。。");
		}finally {
			w.unlock();
		}


	}

	/**
	 * @param key 缓存的键
	 */
	public void getCache(String key){
		r.lock();
		try{
			System.out.println("线程："+Thread.currentThread().getName()+"开始读缓存。。。。");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			Object object = map.get(key);
			System.out.println("线程："+Thread.currentThread().getName()+"读缓存完毕。。。。" + object);
		}finally{
			r.unlock();
		}


	}
}

