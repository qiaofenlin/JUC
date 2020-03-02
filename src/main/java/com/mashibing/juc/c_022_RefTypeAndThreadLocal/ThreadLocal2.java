/**
 * ThreadLocal线程局部变量
 *
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在与ThreadLocal中，避免synchronized的使用
 *
 * 运行下面的程序，理解ThreadLocal
 *
 * ThreadLocal用途 声明式事物，保证一个Connection。
 * 比如一个线程中有多个方法要获得数据库连接，如果不是使用同一个连接，
 * 无法保证多个方法在一个事务下进行，如果将Connection放到ThreadLocal中
 * 每个方法都从ThreadLocal中获取，这样就可以保证多个方法在一个事务中。
 *
 * @author 马士兵
 */
package com.mashibing.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {
	//volatile static Person p = new Person();
	static ThreadLocal<Person> tl = new ThreadLocal<>();
	
	public static void main(String[] args) {
				
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(tl.get());
		}).start();
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/*
			* 可以将数据存储到`ThreadLocalMap`中
			* 每个Thread可以拥有自己的Map
			*
			* */
			tl.set(new Person());
		}).start();
	}
	
	static class Person {
		String name = "zhangsan";
	}
}


