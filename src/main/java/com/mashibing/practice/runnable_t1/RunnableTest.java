package com.mashibing.practice.runnable_t1;

import com.mashibing.practice.User;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Program : JavaNote
 * @ClassName : RunnableTest
 * @Description :
 * @Author : qfl
 * @Date: 2020-04-07 20:28
 */
public class RunnableTest implements Runnable{
    private int i;


    @Override
    public void run() {
        User xxx = new User(i);
        System.out.println(Thread.currentThread().getName() + " Task " + i + "\t start");
//        xxx = null;
        xxx.getAge();
        System.out.println(Thread.currentThread().getName() + " Task " + i + "\t end");
    }

    public RunnableTest(int i) {
        this.i = i;
    }

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());


        /*执行10个任务*/
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new RunnableTest(i));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}
