package Multithreading;

public class ThreadGroupDemo implements Runnable {

	@Override
	public void run() {
		System.out.println("Current Thread : " + Thread.currentThread().getName());

	}

	public static void main(String[] args) throws InterruptedException {

		ThreadGroupDemo obj = new ThreadGroupDemo();

		ThreadGroup tg = new ThreadGroup("Thread Group");

		Thread t1 = new Thread(tg, obj, "one");
		t1.start();

		// This will ensure that once thread 1 finishes then only it goes forward.

		Thread t2 = new Thread(tg, obj, "Two");
		t2.start();

		Thread t3 = new Thread(tg, obj, "Three");
		t3.start();
		t3.join();
	}

}
