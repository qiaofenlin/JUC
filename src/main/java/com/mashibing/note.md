# 复习列表

- synchronized
- volatile
- atomicXXX ---> CAS
- increment ---> sync atimicXXX LongAdder



# 容器
- Collection
    - List
    - Set
    - Queue
        - Deque
            > 双端队列
            - ArrayQueue
            - BlockingQeque
        - BlockingQueue
        - PriorityQueue
        - ConcurrentLinkedQueue
- Map


## Vactor HashTable 都是线程安全的

## Queue VS List
> Queue提供了对多线程友好的API offer peek poll
>
> BlockingQueue 中添加了 put take 阻塞 容易实现生产者消费者模型
>

## 面向接口编程
> 可以根据不同的需求采用不同的额容器


