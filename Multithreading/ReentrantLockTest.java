package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	static ReentrantLock lk;
	
	static class ThreadDemo implements Runnable{
		String name; 
		  ReentrantLock re; 
		  public ThreadDemo(ReentrantLock rl, String n) 
		  { 
		    re = rl; 
		    name = n; 
		  } 
		public void run() {
			// TODO Auto-generated method stub 
		    boolean done =false;
			while (!done) 
		    { 
		      //Getting Outer Lock 
		      boolean ans=false;
			try {
				ans = re.tryLock(1,TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} 
		  
		      // Returns True if lock is free 
		      if(ans) 
		      { 
		    try {
						lk.lock();
		    			System.out.println("Doing some work with thread "+name);
		    			Thread.sleep(1000);
		    	 }
		      
			catch (Exception e) {
				// TODO: handle exception
				//e.printStackTrace();
			}
			finally {
				re.unlock();
				System.out.println("Unlock on thread "+name);
				}
		     }
		    }
		}
		
	}
	public static void main(String[] args) {
		ReentrantLock rel = new ReentrantLock(); 
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Runnable td1 = (Runnable) new ThreadDemo(rel,"1");
		Runnable td2 = (Runnable) new ThreadDemo(rel,"2");
		Runnable td3 = (Runnable) new ThreadDemo(rel,"3");
		Runnable td4 = (Runnable) new ThreadDemo(rel,"4");
		Runnable td5 = (Runnable) new ThreadDemo(rel,"5");
		
		pool.execute(td1);
		pool.execute(td2);
		pool.execute(td3);
		pool.execute(td4);
		pool.execute(td5);
		pool.shutdown();
		
	}

}
