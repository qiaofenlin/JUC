总结：
1：对于map/set的选择使用
HashMap
TreeMap  使用了红黑树
LinkedHashMap

Hashtable
Collections.sychronizedXXX

ConcurrentHashMap
ConcurrentSkipListMap 

2：队列
ArrayList
LinkedList
Collections.synchronizedXXX
CopyOnWriteList
Queue
	CocurrentLinkedQueue //concurrentArrayQueue
	BlockingQueue
		LinkedBQ
		ArrayBQ
		TransferQueue
		SynchronusQueue
	DelayQueue执行定时任务


- Vector HashTable
    - 自带锁 基本不用
- HashTable CHM
- Vector Queue
    - QUEUE List
        - 提供了对线程友好的API offer peek poll
        - BlockingQueue put task 阻塞
- DelayQueue SynchronousQ(单人的手递手) TransferQ(多人的手敌手)


		
	