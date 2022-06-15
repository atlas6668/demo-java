package com.atlas.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by sunwenming on 2017/11/27.
 */
public class ForkJoinTaskDemo extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000;
    private static final int SUB = 100;
    private long start;
    private long end;

    public ForkJoinTaskDemo(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if(canCompute){
            for(long i = start; i <= end; i++){
                sum += i;
            }
        } else {
            long step = (start + end) / SUB;
            List<ForkJoinTaskDemo> subTasks = new ArrayList<ForkJoinTaskDemo>();
            long pos = start;
            for(int i = 0; i < SUB; i++){
                long lastOne = pos + step;
                if(lastOne > end){
                    lastOne = end;
                }
                ForkJoinTaskDemo task = new ForkJoinTaskDemo(pos, lastOne);
                pos += step + 1;
                subTasks.add(task);
                task.fork();
            }
            for(ForkJoinTaskDemo task : subTasks){
                sum += task.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTaskDemo task = new ForkJoinTaskDemo(0, 20000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        long res = result.get();
        System.out.println("sum=" + res);
    }

}
