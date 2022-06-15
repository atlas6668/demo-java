package com.atlas.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunwenming on 2017/9/7.
 */
public class FairLockTask implements Runnable {
    public static ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        try {
            lock.lock();
            if("A".equals(Thread.currentThread().getName())){
                System.out.print("A");
            } else if("B".equals(Thread.currentThread().getName())){
                System.out.print("B");
            } else if("C".equals(Thread.currentThread().getName())){
                System.out.println("C");
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        FairLockTask task = new FairLockTask();
        Thread t1 = new Thread(task, "A");
        Thread t2 = new Thread(task, "B");
        Thread t3 = new Thread(task, "C");
        t1.start();t2.start();t3.start();
    }

}

class FairLockDemo {
    public static ReentrantLock lock = new ReentrantLock(true);
    private static int state = 0;

    static class TaskA implements Runnable {
        public void run() {
            for(int i = 0; i < 5; i++){
                try {
                    lock.lock();
                    while(state % 3 == 0){
                        System.out.print("A");
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class TaskB implements Runnable {
        public void run() {
            for(int i = 0; i < 5; i++){
                try {
                    lock.lock();
                    while(state % 3 == 1){
                        System.out.print("B");
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class TaskC implements Runnable {
        public void run() {
            for(int i = 0; i < 5; i++){
                try {
                    lock.lock();
                    while(state % 3 == 2){
                        System.out.println("C");
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

//    public static void main(String[] args){
//        Thread t1 = new Thread(new TaskA());
//        Thread t2 = new Thread(new TaskB());
//        Thread t3 = new Thread(new TaskC());
//        t1.start();t2.start();t3.start();
//    }

}
