package com.atlas.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunwenming on 2017/8/17.
 * ReentrantLock 重入锁
 * 特性一 中断响应
 * 特性二 公平锁
 * 特性三 好搭档 condition 应用 参考 ArrayBlockingQueue 的 实例变量 notEmpty notFull 方法 put() insert() take() extract()
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public void run() {
        for(int j = 0; j < 10000000; j++){
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
