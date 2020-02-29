## volatile 
- 保证线程可见性
    - 本质上使用的是:MESI ---> CPU的缓存一致性协议
    links:[JMM](https://www.jianshu.com/p/8a58d8335270)
- 禁止指令重排序
    cpu指令的执行是流水线执行,为了充分发挥该特性， 编译器需要把源码编译完之后，可能进行指令的
    重新排序，汇编语言的重排序。
    
    - [Double Check Lock](Mgr06.java) 