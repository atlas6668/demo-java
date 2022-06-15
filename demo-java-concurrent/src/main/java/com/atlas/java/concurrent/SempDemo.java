package com.atlas.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by sunwenming on 2017/8/13.
 * 多个线程同时访问：信号量
 */
public class SempDemo implements Runnable {
    // 信号量 5 ：同时允许 5 个 线程执行 run 任务
    final Semaphore semp = new Semaphore(5, true);

    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            semp.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SempDemo demo = new SempDemo();
        for(int i = 0; i < 20; i++){
            exec.submit(demo);
        }
        exec.shutdown();
    }

}
