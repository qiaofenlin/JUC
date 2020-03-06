package com.mashibing.juc.c_026_01_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T08_CachedPool {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * 只要启动任务 就会创建新的线程
		 */

		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service);
		for (int i = 0; i < 10; i++) {
			service.execute(() -> {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		System.out.println(service);

		TimeUnit.SECONDS.sleep(80);

		System.out.println(service);


	}
}
