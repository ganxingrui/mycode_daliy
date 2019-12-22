package com.daliy.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lenovo
 * @date 2019/10/30 22:35
 */
public class ThreadLocalDemo {
	public static void main(String[] args) {
		final ThreadLocal<Map> threadLocal = new ThreadLocal<>();

		new Thread(new Runnable() {
			@Override
			public void run() {
				final HashMap hashMap = new HashMap();
				hashMap.put("20191001","张三|男|三年级");
				hashMap.put("20191002","李四|男|二年级");
				threadLocal.set(hashMap);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
				//注意threadLocal内存泄漏？源码分析
				threadLocal.remove();
			}
		},"A").start();


		new Thread(new Runnable() {
			@Override
			public void run() {
				//测试在A线程存放数据，在B线程能获取到吗？
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
			}
		},"B").start();
	}
}
