package com.atlas.java.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by sunwenming on 2017/8/17.
 * 线程阻塞工具类 ：LockSupport
 */
public class LockSupportIntDemo {
    public static Object u = new Object();
    static ChangeObjectTread t1 = new ChangeObjectTread("t1");
    static ChangeObjectTread t2 = new ChangeObjectTread("t2");

    public static class ChangeObjectTread extends Thread {
        public ChangeObjectTread(String name){
            super.setName(name);
        }

        public void run() {
            synchronized(u){
                System.out.println("in " + getName());
                LockSupport.park();
                if(Thread.interrupted()){
                    System.out.println(getName() + " 被中断了");
                }
            }
            System.out.println(getName() + " 执行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }
}
