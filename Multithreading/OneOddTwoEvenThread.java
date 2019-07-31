package Multithreading;

import java.util.concurrent.Semaphore;

public class OneOddTwoEvenThread {
	
	public static void main(String[] args) {
		
		Semaphore odd = new Semaphore(1);  // first thread is allowed to run immediately
		Semaphore even = new Semaphore(0); // second thread has to wait
		
		ThreadPrinter tp1 = new ThreadPrinter(1, odd, even);
		ThreadPrinter tp2 = new ThreadPrinter(2, even, odd); 
		
		Thread t1 = new Thread(tp1,"Odd Thread");
		Thread t2 = new Thread(tp2, "Even Thread");
		t1.start();
		t2.start();
		
	}
}

	class ThreadPrinter implements Runnable {
		int counter;
		Semaphore first, second;
		
		ThreadPrinter(int counter, Semaphore first, Semaphore second) {
		    this.counter = counter;
		    this.first = first;
		    this.second = second;
		}

		@Override
		public void run() {
		    for (int i = counter; counter <= 50; i++) {
		        try {
		        	first.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // wait for permission to run
		        System.out.println(Thread.currentThread().getName() + " : "+ counter);
		        counter += 2;
		        second.release();  // allow another thread to run       
		    }
		}

}