package com.mashibing.juc.runnable_error;

import java.util.concurrent.*;

/**
 * @Program : JUC_new
 * @ClassName : RunnableTest
 * @Description :
 * @Author : qfl
 * @Date: 2020-04-07 19:54
 */

public class RunnableTest {
    private static ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(50, 50,
            60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(4),
            new MyThreadFactory("backUpPool"),
            new ThreadPoolExecutor.DiscardOldestPolicy());


    static class Task implements Runnable {
        private int i;

        public Task(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        @Override
        public void run() {
            User xxx = new User(i);
            System.out.println(Thread.currentThread().getName() + " Task " + i + "\t start");
            xxx = null;
            xxx.getAge();
            System.out.println(Thread.currentThread().getName() + " Task " + i + "\t end");
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }
    }

    static class MyHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//            System.out.println();("r rejected")
//            save r kafka mysql redis
//            try 3 times


//            System.out.println("RejectedExecutionHandler:" + executor.getCorePoolSize());
            if (executor.getQueue().size() < 10000) {
                try {
                    Runnable runnable = executor.getQueue().poll(1, TimeUnit.SECONDS);
                    threadPoolExecutor2.execute(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                //try put again();
            }
        }
    }


    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                new MyThreadFactory("XXXName"),
//                new RunnableTest.MyHandler());
                new ThreadPoolExecutor.DiscardPolicy());


        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Task(i));
        }

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("========================== start 2");

//        for (int i = 1000; i < 1020; i++) {
//            threadPoolExecutor.execute(new Task(i));
//        }
//
//        System.out.println("============================end ");


    }
}
