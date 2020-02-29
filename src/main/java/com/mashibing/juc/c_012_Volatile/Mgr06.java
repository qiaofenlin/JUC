package com.mashibing.juc.c_012_Volatile;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE; //JIT

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Mgr06.class) {
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                    /*
                    * JVM编译器编译完成之后，创建对象的指令分为3步:
                    * 1.分配(申请)内存，赋初始值int 0
                    * 2.成员变量初始化 具体值 int a=8
                    * 3.将变量的指针赋值给`INSTANCE`
                    *
                    * 在极高并发的状态，编译器会进行指令重排序，一个线程如果创建`INSTANCE`的指令执行到第一步时，就执行3，
                    * 第二个线程进来进行
                    *    if(INSTANCE == null)  INSTANCE 不是null了，已经初始化了对应的文档，
                    * 所以第二个线程进来之后直接就返回了，但是单例对象完全创建完成。容易造成问题。
                    * 
                    * 如果单例对象加了volatile修饰，根据volatile的禁止指令重排序，会依次执行123,最后给`INSTANCE`赋值。
                    *
                     * */
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
