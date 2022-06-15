package com.atlas.java.concurrent;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunwenming on 2017/8/17.
 * ReentrantLock 重入锁 特性一 中断相应
 */
public class IntLock implements Runnable {
    public static ReentrantLock reentrantLock1 = new ReentrantLock();
    public static ReentrantLock reentrantLock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock){
        this.lock = lock;
    }

    public void run() {
        try {
            if (lock == 1) {
                reentrantLock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock2.lockInterruptibly();
            } else {
                reentrantLock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock1.lockInterruptibly();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            if(reentrantLock1.isHeldByCurrentThread()){
                reentrantLock1.unlock();
            }
            if(reentrantLock2.isHeldByCurrentThread()){
                reentrantLock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + "：线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock intLock1 = new IntLock(1);
        IntLock intLock2 = new IntLock(2);
        Thread thread1 = new Thread(intLock1);
        Thread thread2 = new Thread(intLock2);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        // 中断其中一个线程
        thread2.interrupt();
    }
}
