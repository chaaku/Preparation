package Multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	static Semaphore semaphore = new Semaphore(2);
	
	static class ATMMachine extends Thread{
		
		String name ;
		public ATMMachine(String str) {
			// TODO Auto-generated constructor stub
			this.name=str;
		}
		
		
		@Override
		public void run() {
			try {
				System.out.println("Acquiring Lock...");
				semaphore.acquire();
				System.out.println("Thread "+name+ " Got the permit...");
				try {
					System.out.println("Thread " +name+ " "
							+ "acquired and executing task"
							+" Available permit after acquire "+semaphore.availablePermits());					
				} 
				finally {
					semaphore.release();
					System.out.println(" After relaese >>> availablePermits() :"+semaphore.availablePermits());
				}			
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ATMMachine _1 = new ATMMachine("1");
		ATMMachine _2 = new ATMMachine("2");
		ATMMachine  _3 = new ATMMachine("3");
		ATMMachine  _4 = new ATMMachine("4");
		ATMMachine  _5 = new ATMMachine("5");
		ATMMachine  _6 = new ATMMachine("6");
		 _1.start();
		 _2.start();
		 _3.start();
		 _4.start();
		 _5.start();
		 _6.start();
		 
		
	}
	

}
