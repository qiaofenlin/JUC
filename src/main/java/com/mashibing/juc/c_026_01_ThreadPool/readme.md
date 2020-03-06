Executor 
ExecutorService submit
Callable = Runnable
Executors 
ThreadPool
Future

fixed cached single scheduled workstealing forkjoin

ThreadpoolExecutor

PStreamAPI


=============================================================

Callable -> Runnable+ret

Future -> 存储执行的将来才会产生的结果

FutureTask -> Future+Runable

CompletableFuture 管理多个Future的结果

---

> 线程池有两种 一种是ThreadPoolExcutor 另一种是ForkJoinPool 
>前者 多个线程拥有一个任务队列 后者每个线程都有自己的任务队列

# ThreadPoolExcutor
维护了两个集合 一个是线程的集合(hashSet) 一个是任务的集合

7个参数
- 核心线程数
- 最大线程数
- keepAliveTime
- TimeUnit.SECONDS
- BlockQueue
- 拒绝策略
    - AbortPolicy 直接抛异常
    - CallerRunsPolicy 调用该任务的线程执行
    - DiscardOldestPolicy 将最老的丢弃
    - DiscardPolicy 直接抛弃

# ForkJoinPool
- 分解汇总任务
- 用很少的线程可以执行很多的任务(子任务) TPE做不到先执行子任务
- CPU密集型



# Executor

# ExecutorService

# ThreadPoolExecutor
    - corePoolSize
    - maxPoolSize
    - keepAliveTime
    - TimeUnit
    - BlockQueue
    - ThreadFactory线程工厂
    - RejectStrategy
        - Abort
        - Discard
        - DiscardOldestPolicy
        - CallerRuns


# Exeutors 线程池工厂
- SingleThreadExecutor 为什么要有单线程的线程池？
 > 1.任务队列 2.完整的生命周期

- FixedThreadPool VS CachedPool
>线程池的大小: N(thread) = N(cpu)*U(cpu)*(1+W/C)
    W Wait
    C Computing time;
> Fixed
  Cached 任务数忽高忽低

# Scheduled定时任务线程池
> quartz cron
 面试:假如提供一个闹钟服务,订阅这个服务的人特别多，10亿人 怎么优化。


# Concurrent VS parallel

> 并发是任务提交 并行是指任务执行 过个cpu进行执行
> 并行是并发的子集


# ThreadPoolExecutor
> 源码

# workStealingPool
```
1. 多个work queue
2. 采用work stealing算法

每个线程维护者自己的队列 当自己队列中的数据消费完时，通过 poll 其他队列中 work steal

```

## ForkJoinPool
```text
RecursiveAction ： compute 使用递归的方式进行fork

```




