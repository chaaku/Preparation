package Multithreading;

import java.util.LinkedList;
import java.util.List;

/**
 * Simple Thread Pool which provides a simple fixed threadpool
 *
 * @author Chandan
 */
public class SimpleThreadpool {
	
	private WorkerThread [] threads;
	private List <Runnable> taskQueue;
	
	public SimpleThreadpool(int threadNumber) {
		taskQueue = new LinkedList<>();		
		threads = new WorkerThread[threadNumber];
		
		for(int i=0; i<threads.length;i++) {
			threads[i]=new WorkerThread();
			threads[i].start();
		}
	}

	public static void main(String[] args) {
	SimpleThreadpool pool = new SimpleThreadpool(3);

    for (int i = 0; i < 15; i++) {
    		Task task = new Task(i);
        	pool.addTaskToQueue(task);
    	}
	}
	
	public void addTaskToQueue (Runnable r) {
		synchronized (taskQueue) {
			taskQueue.add(r);
			taskQueue.notify();
		}
	}
	
	private class WorkerThread extends Thread{
		
		public void run() {
			Runnable r;
			
			while(true) {
				synchronized (taskQueue) {
					while(taskQueue.isEmpty()) {
						try {
							taskQueue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
					r = (Runnable) taskQueue.remove(0); 
				}
				try {
					r.run();
				} catch (Exception e) {
				// ignore 
				}
			}
		}
	}
	
}