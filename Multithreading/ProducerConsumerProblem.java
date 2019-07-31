package Multithreading;

import java.util.concurrent.*;

public class ProducerConsumerProblem {

	public static void main(String[] args) {

		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

		Thread ProducerThread = new Thread(new Producer1(sharedQueue));
		Thread ConsumerThread = new Thread(new Consumer1(sharedQueue));

		ProducerThread.start();
		ConsumerThread.start();
	}
}

class Producer1 implements Runnable {

	private BlockingQueue<Integer> sharedQueue;

	public Producer1(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Produced :" + i);
				sharedQueue.add(i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

}

class Consumer1 implements Runnable {

	private BlockingQueue<Integer> sharedQueue;

	public Consumer1(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed :" + sharedQueue.take());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}