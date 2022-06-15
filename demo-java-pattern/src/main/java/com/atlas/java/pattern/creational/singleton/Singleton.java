/**
 * <p>Title: Singleton.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月8日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.singleton;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;

/**
 * <p>Title: Singleton</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月8日
 */
public class Singleton {

	private Singleton() {
		System.out.println("已产生对象实例。");
	}

	private static class SingletonHolder {
		private static Singleton singleton = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHolder.singleton;
	}
}

class ActiveSingleton {
	/**
	 * 积极加载
	 */
	private static ActiveSingleton activeSingleton = new ActiveSingleton();

	private ActiveSingleton() {
		System.out.println("已产生对象实例。");
	}

	public static ActiveSingleton getInstance() {
		return activeSingleton;
	}
}

class LazySingleton {
	/**
	 * 延迟加载
	 */
	private static LazySingleton lazySingleton;

	private LazySingleton() {
		System.out.println("已产生对象实例。");
	}

	public static synchronized LazySingleton getInstance() {
		if(lazySingleton == null){
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
}

/**
 * 比较 积极加载，延迟加载，内部类延迟加载 性能
 */
class Sum implements Runnable {
	private final CyclicBarrier cyclic;

	Sum(CyclicBarrier cyclic){
		this.cyclic = cyclic;
	}

	public void run() {
		try {
			// 等待 第一次 计数完成
			cyclic.await();
			doWork0();
			// 等待 下一次 计数完成
			cyclic.await();
			doWork1();
			// 等待 下一次 计数完成
			cyclic.await();
			doWork2();
			// 等待 下一次 计数完成
			cyclic.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	// 内部类加载
	void doWork0() throws InterruptedException {
		for(int i = 0; i < 100000; i++){
			Singleton.getInstance();
		}
		System.out.println("线程[" + Thread.currentThread().getName() + "] 完成任务");
	}

	// 积极加载
	void doWork1() throws InterruptedException {
		for(int i = 0; i < 100000; i++){
			ActiveSingleton.getInstance();
		}
		System.out.println("线程[" + Thread.currentThread().getName() + "] 完成任务");
	}

	// 延迟加载
	void doWork2() throws InterruptedException {
		for(int i = 0; i < 100000; i++){
			LazySingleton.getInstance();
		}
		System.out.println("线程[" + Thread.currentThread().getName() + "] 完成任务");
	}
}

class BarrierRun implements Runnable {
	int m = 1;
	int n;
	long begin;

	public BarrierRun(int n){
		this.n = n;
	}

	@Override
	public void run() {
		if(m % 4 == 1){
			System.out.println("线程[" + n + "]个 准备就绪！");
			begin = System.currentTimeMillis();
			m++;
		} else if (m % 4 == 2) {
			System.out.println("单例[内部类延迟加载]任务完成 spend : " + (System.currentTimeMillis() - begin));
			begin = System.currentTimeMillis();
			m++;
		} else if (m % 4 == 3) {
			System.out.println("单例[积极加载]任务完成 spend : " + (System.currentTimeMillis() - begin));
			begin = System.currentTimeMillis();
			m++;
		} else {
			System.out.println("单例[延迟加载]任务完成 spend : " + (System.currentTimeMillis() - begin));
		}
	}
}

class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 比较 积极加载，延迟加载，内部类延迟加载 性能
		int n = 3;
		// 循环栅栏
		CyclicBarrier cyclic = new CyclicBarrier(n, new BarrierRun(n));
		Thread[] alllSum = new Thread[n];
		for(int i = 0; i < n; i++){
			alllSum[i] = new Thread(new Sum(cyclic));
			alllSum[i].start();
		}
	}
}
