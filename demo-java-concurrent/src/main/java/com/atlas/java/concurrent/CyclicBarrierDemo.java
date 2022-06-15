package com.atlas.java.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by sunwenming on 2017/8/15.
 * 循环栅栏：CyclicBarrier  比 CountDownLatch 复杂强大
 * 反复使用计数器 计数器归零 然后 下一次计数倒计时
 */
public class CyclicBarrierDemo {

    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        Soldier(CyclicBarrier cyclic, String soldierName){
            this.cyclic = cyclic;
            this.soldier = soldierName;
        }

        public void run() {
            try {
                // 等待 第一次 计数完成
                cyclic.await();
                doWork();
                // 等待 下一次 计数完成
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() throws InterruptedException {
            Thread.sleep(Math.abs(new Random().nextInt() % 10000));

            System.out.println(soldier + "：任务完成");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;
        public BarrierRun(boolean flag, int N){
            this.flag = flag;
            this.N = N;
        }

        public void run() {
            if(flag){
                System.out.println("司令：[士兵" + N + "个，任务完成！]");
            } else {
                System.out.println("司令：[士兵" + N + "个，集合完毕！]");
                flag = true;
            }
        }
    }

    public static void main(String[] args){
        final int N = 10;
        Thread[] alllSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合队伍！");
        for(int i = 0; i < N; i++){
            alllSoldier[i] = new Thread(new Soldier(cyclic, "士兵 " + i));
            System.out.println("士兵 " + i + " 报道！");
            alllSoldier[i].start();
        }
    }

}
