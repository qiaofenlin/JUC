# AQS

## 为什么AQS的底层是 CAS和volatile
```java
public abstract class AbstractQueuedSynchronizer {
       /**
         * The synchronization state.
            在reentrantLock中代表 1:加锁和0:解锁 重入了多少次
            在CountDownLanch中代表 countDown多少次
         */
    private volatile int state;
}
```
## 架构
> status + LinkList<Node> Node中存的是thread

>  CAS的操作替代锁整个链表的操作，只是对head/tail进行cas操作，性能更高

