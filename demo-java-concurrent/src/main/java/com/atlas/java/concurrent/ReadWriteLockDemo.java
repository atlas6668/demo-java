package com.atlas.java.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sunwenming on 2017/8/17.
 * 读写分离锁 ReadWriteLock
 * ----------------------------------------------
 * |          |  读            |  写             |
 * ----------------------------------------------
 * |  读      |  非阻塞         |  阻塞           |
 * ----------------------------------------------
 * |  写      |  阻塞           |  阻塞           |
 * ----------------------------------------------
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object hadlerRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);//模拟读操作
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void hadlerWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);//模拟写操作
            value = index;
        } finally {
            lock.unlock();
        }
    }

    private class ReadRunnable implements Runnable {
        private ReadWriteLockDemo demo;

        public ReadRunnable(ReadWriteLockDemo demo){
            this.demo = demo;
        }

        public void run() {
            try {
                demo.hadlerRead(readLock);
//                demo.hadlerRead(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class WriteRunnable implements Runnable {
        private ReadWriteLockDemo demo;

        public WriteRunnable(ReadWriteLockDemo demo){
            this.demo = demo;
        }

        public void run() {
            try {
                demo.hadlerWrite(writeLock, new Random().nextInt());
//                demo.hadlerWrite(lock, new Random().nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        for(int i = 0; i < 18; i++){
            new Thread(demo.new ReadRunnable(demo)).start();
        }

        for(int i = 18; i < 20; i++){
            new Thread(demo.new WriteRunnable(demo)).start();
        }
    }
}
