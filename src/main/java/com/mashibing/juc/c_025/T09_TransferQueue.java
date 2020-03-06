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
		 *  װ�����ݺ󣬵���(����),�����˰�����ȡ��  �Ż�����ɻ  put�����˲Ż���ţ�transfer���в���Ҳ��������
		 *
		 *  ������ �����ӵ�MQ�У���ȷ�����ݱ������˸��û�����������ʹ�ø�ģ�͡�
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
