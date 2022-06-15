package com.atlas.java.concurrent;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunwenming on 2017/8/17.
 * ReentrantLock 重入锁 锁申请等待限时
 */
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    public void run() {
        try {
            // 申请获得锁 等待时间 时间单位
            if(lock.tryLock(2, TimeUnit.SECONDS)){
//            if(lock.tryLock(3, TimeUnit.SECONDS)){
//            if(lock.tryLock(4, TimeUnit.SECONDS)){
                Thread.sleep(3000);//模拟锁占有时间
                System.out.println(Thread.currentThread().getId() + "get lock successful");
            } else {
                System.out.println(Thread.currentThread().getId() + "get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        TimeLock timeLock = new TimeLock();
        Thread thread1 = new Thread(timeLock);
        Thread thread2 = new Thread(timeLock);
        thread1.start();
        thread2.start();
    }
}
