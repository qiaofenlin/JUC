//package com.mashibing.juc.c_021_03_VarHandle;
///**
// * JDK1.9之后才有的
// *
// * varhandle 指向某个变量的handle
// *
// *1. 可以进行一些原子性线程安全的操作。
// *2. 比反射快，直接操作二进制码
// *
// */
//
//import java.lang.invoke.MethodHandles;
//import java.lang.invoke.VarHandle;
//
//public class T01_HelloVarHandle {
//
//    int x = 8;
//
//    private static VarHandle handle;
//
//    static {
//        try {
//            handle = MethodHandles.lookup().findVarHandle(T01_HelloVarHandle.class, "x", int.class);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        T01_HelloVarHandle t = new T01_HelloVarHandle();
//
//        //plain read / write
//        System.out.println((int)handle.get(t));
//        handle.set(t,9);
//        System.out.println(t.x);
//
//        handle.compareAndSet(t, 9, 10);
//        System.out.println(t.x);
//
//        handle.getAndAdd(t, 10);
//        System.out.println(t.x);
//
//    }
//}
