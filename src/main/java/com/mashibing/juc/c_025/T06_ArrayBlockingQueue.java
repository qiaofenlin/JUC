package com.mashibing.juc.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {

	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

	static Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			strs.put("a" + i);
		}
		System.out.println(strs);

		for (int i = 0; i < 11; i++) {
			String s = strs.poll(1, TimeUnit.SECONDS);
			System.out.println("strs poll:"+s);
		}
		strs.put("aaa"); //满了就会等待，程序阻塞
		//strs.add("aaa");
		//strs.offer("aaa");
//		boolean aaa = strs.offer("aaa", 1, TimeUnit.SECONDS);
//		System.out.println("strs offer:"+aaa);
		System.out.println(strs);
	}
}
