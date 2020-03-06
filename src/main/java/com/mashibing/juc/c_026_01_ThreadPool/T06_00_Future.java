/**
 * 认识future
 * 异步
 */
package com.mashibing.juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class T06_00_Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/**
		 * FutureTask 更好用  Callable Future 的结合
		 */
		FutureTask<Integer> task = new FutureTask<>(()->{
			TimeUnit.MILLISECONDS.sleep(500);
			System.out.println("subthread");
			return 1000;
		}); //new Callable () { Integer call();}
		
		new Thread(task).start();
		
		System.out.println(task.get()); //阻塞


	}
}
