package com.atlas.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunwenming on 2017/9/7.
 */
public class ReentrantLockTask implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i;// i = 0 i 赋值 0 或者 不赋值 不影响 因为静态变量 在类加载的准备阶段会被赋默认值

    public void run() {
        for(int j = 0; j < 10000000; j++){
            lock.lock();
            try {
                i++;
            } finally {
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTask task = new ReentrantLockTask();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }

}
