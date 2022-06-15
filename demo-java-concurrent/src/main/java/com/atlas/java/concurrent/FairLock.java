package com.atlas.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunwenming on 2017/8/17.
 * ReentrantLock 重入锁 特性二 公平锁
 */
public class FairLock implements Runnable {
    // 实例化 ReentrantLock 带公平锁参数的构造
    public static ReentrantLock lock = new ReentrantLock(true);
    private static volatile boolean out = false;
    private int count;

    public void run() {
        while(true){
            if(out){
                break;
            }
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " getted lock");
                if(++count > 100){
                    out = true;
                }
            } finally {
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args){
        FairLock fairLock = new FairLock();
        Thread thread1 = new Thread(fairLock);
        Thread thread2 = new Thread(fairLock);
        thread1.start();
        thread2.start();
    }
}
