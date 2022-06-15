package com.atlas.java.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by sunwenming on 2017/8/16.
 * 分而治之 ：Fork/Join 框架
 */
public class CountTask extends RecursiveTask<Long> {
    // THRESHOLD 任务分解的规模
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canComputer = (end - start) < THRESHOLD;
        // 如果任务 小于 任务分解的规模 可以立即执行，否则对任务再次分解
        if(canComputer){
            for(long i = start; i <= end; i++){
                sum += i;
            }
        } else {
            // 分成 100 个小任务
            long step = (start + end) / 100;
            ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
            long pos = start;
            for(int i = 0; i < 100; i++){
                long lastOne = pos + step;
                if(lastOne > end){
                    lastOne = end;
                }
                CountTask subTask = new CountTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for(CountTask t : subTasks){
                sum += t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // ForkJoinPool 线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        long res = result.get();
        System.out.println("sum=" + res);
    }
}
