/**
 * 弱引用遭到gc就会回收
 *
 */
package com.mashibing.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        /**
         * m=WeakReference ---new M()
         *
         * 强引用了 new M()的对象，如果这个强引用消失，则m应该被垃圾回收
         *
         */
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());


        ThreadLocal<M> tl = new ThreadLocal<>();

        tl.set(new M());
        /*容易造成内存泄漏，所以使用完之后要掉*/
        tl.remove();

    }
}

