package com.atlas.java.jvm.o;

/**
 * Created by sunwenming on 2017/11/18.
 */
public class MultiThreadTest {
    public static void divSleep(long millis) throws IllegalArgumentException {
        long base = System.currentTimeMillis();
        long now = 0;
        if(millis < 0){
            throw new IllegalArgumentException("timeout value is negative");
        }
        while(true){
            long delay = millis - now;
            if(delay <= 0){
                break;
            }
            now = System.currentTimeMillis() - base;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(5000);
//                    System.out.println(Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                MultiThreadTest.divSleep(5000);
            }
        };
        long start = System.currentTimeMillis();
        Thread threadA = new Thread(task);
        Thread threadB = new Thread(task);
        threadA.start();
        Thread.sleep(2000);
        System.out.println("spend 1 : " + (System.currentTimeMillis() - start));
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("spend 2 : " + (System.currentTimeMillis() - start));
    }

}