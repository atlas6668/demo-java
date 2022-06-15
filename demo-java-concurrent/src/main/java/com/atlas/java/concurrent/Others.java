package com.atlas.java.concurrent;

/**
 * Created by sunwenming on 2017/8/17.
 * JDK 的并发容器
 * 阅读源码
 * ConcurrentHashMap,
 * CopyOnWriteArrayList, 写入不会阻塞读操作 通过将修改的内容写入副本 写完将副本替换原来数据 volatile 修饰变量 保证写先发生于读
 * ConcurrentLinkedQueue, 高并发环境中性能最好的队列  方法：offer() 线程安全完全有CAS操作和队列的算法来保证
 * BlockingQueue, 方法：put(),take()是体现阻塞等待的关键 阅读 ArrayBlockingQueue 加深理解
 * ConcurrentSkipListMap; 多层链表实现 所有的链表元素都是排序的 空间换时间算法
 */
public class Others {
}
