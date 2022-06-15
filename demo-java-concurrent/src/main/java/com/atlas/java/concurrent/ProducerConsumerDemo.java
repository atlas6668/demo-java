package com.atlas.java.concurrent;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunwenming on 2017/11/27.
 */
public class ProducerConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<PCData>(10);
//        BlockingQueue<PCData> queue = new ArrayBlockingQueue<PCData>(10);
        ProducerTask producerTask1 = new ProducerTask(queue);
        ProducerTask producerTask2 = new ProducerTask(queue);
        ProducerTask producerTask3 = new ProducerTask(queue);

        ConsumerTask consumerTask1 = new ConsumerTask(queue);
        ConsumerTask consumerTask2 = new ConsumerTask(queue);
        ConsumerTask consumerTask3 = new ConsumerTask(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producerTask1);
        executorService.execute(producerTask2);
        executorService.execute(producerTask3);

        executorService.execute(consumerTask1);
        executorService.execute(consumerTask2);
        executorService.execute(consumerTask3);

        Thread.sleep(20 * 1000);
        producerTask1.stop();
        producerTask2.stop();
        producerTask3.stop();

        Thread.sleep(5000);
        executorService.shutdown();

    }

}

final class PCData {
    private final int intData;
    public PCData(int d){
        this.intData = d;
    }
    public int getIntData(){
        return intData;
    }
}

class ProducerTask implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public ProducerTask(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    public void run() {
        PCData data;
        Random r = new Random();
        System.out.println("start producer id=" + Thread.currentThread().getId());
        try {
            while(isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());
                System.out.println(data + " is put into queue");
                if(!queue.offer(data, 2, TimeUnit.SECONDS)){
                    System.err.println("failed to put data: " + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}

class ConsumerTask implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public ConsumerTask(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    public void run() {
        System.out.println("start consumer id=" + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while(isRunning){
                PCData data = queue.take();
                if(null != data){
                    int re = data.getIntData() * data.getIntData();
                    System.out.println(MessageFormat.format("{0} * {1} = {2}", data.getIntData(), data.getIntData(), re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
