package com.mashibing.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T09_TransferQueue {
	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

		/**
		 *
		 */

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		/**
		 *  装完数据后，等着(阻塞),等有人把数据取走  才会继续干活。  put是慢了才会等着，transfer队列不满也会阻塞。
		 *
		 *  适用于 订单扔到MQ中，等确保数据被处理了给用户反馈，可以使用该模型。
		 */
		strs.transfer("aaa");
		
		//strs.put("aaa");


		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/


	}
}
