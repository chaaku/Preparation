package Multithreading;

/*
// with a thread class
public class ThreadDemo extends Thread {
	
	
	public ThreadDemo() {
		
		System.out.println("Thread is created");
	}
	
	@Override
	public void run() {
		System.out.println("\nThread is Running !!");
	}
	
	
	public static void main(String[] args) {
		ThreadDemo t = new ThreadDemo();
		t.start(); 
		
	}
*/

// with implement runnable interface
public class ThreadDemo implements Runnable {

	public ThreadDemo() {
		System.out.println("Thread is Created");
	}

	@Override
	public void run() {
		System.out.println("Thread is running");
	}

	public static void main(String[] args) {

		ThreadDemo td = new ThreadDemo();
		Thread t = new Thread(td);
		t.start();
	}

}
