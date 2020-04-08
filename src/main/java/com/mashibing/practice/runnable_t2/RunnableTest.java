package com.mashibing.practice.runnable_t2;

import com.mashibing.practice.MyThreadFactory;
import com.mashibing.practice.User;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Program : JavaNote
 * @ClassName : RunnableTest
 * @Description :
 * @Author : qfl
 * @Date: 2020-04-07 20:28
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

            if (executor.getQueue().size() < 4) {
                //try put again();

            }
        }
    }


    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                new MyThreadFactory("XXXName"),
                new RunnableTest.MyHandler());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Task(i));
        }

    }
}
