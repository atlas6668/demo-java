package com.atlas.java.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sunwenming on 2017/8/13.
 * 倒计时器 CountDownLatch
 */
public class CountDownLatchDemo implements Runnable {
    // 计数量 10 ：倒计时 10
    static final CountDownLatch end = new CountDownLatch(10);

    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println(Thread.currentThread().getName() + "check complete");
            // 计数量 -1
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        CountDownLatchDemo demo = new CountDownLatchDemo();
        for(int i = 0; i < 20; i++){
            exec.submit(demo);
        }
        // 等待 倒计时完
        end.await();
        System.out.println("Fire!");
        exec.shutdown();
    }
}

