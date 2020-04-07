package com.mashibing.practice.runnable_t3;

/**
 * @Program : JUC_new
 * @ClassName : AsyncTest
 * @Description :
 * @Author : qfl
 * @Date: 2020-04-08 00:48
 */

public class AsyncTest {
    public static void main(String[] args) {
        AsyncProcessQueue.execute(new Runnable() {
            @Override
            public void run() {
                //do something
            }
        });
    }
}
