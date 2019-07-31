package Multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerThread implements Runnable {

	public static void main(String[] args) {
		int size = 5;
		ExecutorService ex = Executors.newFixedThreadPool(size);
		for (int i = 1; i <= size; i++) {
			WorkerThread worker = new WorkerThread();
			// Runnable worker = new WorkerThread(""+i);
			// new Thread(w).start(); // This will be asynchronous
			ex.execute(worker); // This will be synchronous/ Parallel
		}

		ex.shutdown();
		
		while (!ex.isTerminated()){};
		
		System.out.println("Finished All Threads from pool 1........");
		//System.out.println("Finished All Threads from pool 2........");

	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + "  started .....");
		processMessage();
		System.out.println(Thread.currentThread().getName() + " ended.");

	}

	public static void processMessage() {
		try {
			System.out.println(Thread.currentThread().getName() + " Processing");
			Thread.sleep(2000);
		} catch (InterruptedException e) {};
	}



}
