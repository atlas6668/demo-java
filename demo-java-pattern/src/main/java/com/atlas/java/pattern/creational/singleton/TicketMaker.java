/**
 * <p>Title: TicketMaker.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月8日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>Title: TicketMaker</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月8日
 */
public class TicketMaker {

	private static TicketMaker ticketMaker;
	private int ticket = 10000;
	
	private TicketMaker() {

	}
	
	public static synchronized TicketMaker getInstance() {
		if(ticketMaker == null){
			ticketMaker = new TicketMaker();
		}
		return ticketMaker;
	}
	
	public synchronized int getNextTicketNumber() {
		return ticket++;
	}

//	private ReentrantLock lock = new ReentrantLock();
//	private int getNextTicketNumber() {
//		lock.lock();
//		try {
//			ticket++;
//		} finally {
//			if(lock.isHeldByCurrentThread()){
//				lock.unlock();
//			}
//		}
//		return ticket;
//	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		List<Future> list = new ArrayList<Future>();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100000; i++){
					TicketMaker.getInstance().getNextTicketNumber();
				}
			}
		};
		for(int i = 0; i < 10; i++){
			list.add(exec.submit(runnable));
		}
		for(Future future : list){
			future.get();
		}
		exec.shutdown();
		System.out.println(TicketMaker.getInstance().ticket);

	}
}
