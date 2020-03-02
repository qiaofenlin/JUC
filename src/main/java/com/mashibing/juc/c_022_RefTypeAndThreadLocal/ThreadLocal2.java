/**
 * ThreadLocal�ֲ߳̾�����
 *
 * ThreadLocal��ʹ�ÿռ任ʱ�䣬synchronized��ʹ��ʱ�任�ռ�
 * ������hibernate��session�ʹ�����ThreadLocal�У�����synchronized��ʹ��
 *
 * ��������ĳ������ThreadLocal
 *
 * ThreadLocal��; ����ʽ�����֤һ��Connection��
 * ����һ���߳����ж������Ҫ������ݿ����ӣ��������ʹ��ͬһ�����ӣ�
 * �޷���֤���������һ�������½��У������Connection�ŵ�ThreadLocal��
 * ÿ����������ThreadLocal�л�ȡ�������Ϳ��Ա�֤���������һ�������С�
 *
 * @author ��ʿ��
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
			* ���Խ����ݴ洢��`ThreadLocalMap`��
			* ÿ��Thread����ӵ���Լ���Map
			*
			* */
			tl.set(new Person());
		}).start();
	}
	
	static class Person {
		String name = "zhangsan";
	}
}


