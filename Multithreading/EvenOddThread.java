package Multithreading;

public class EvenOddThread {

	public static void main(String[] args) {
		Thread evenThread = new Thread(new Even(), "EVEN-THREAD");
		Thread oddThread = new Thread(new Odd(), "ODD-THREAD");

		evenThread.start();
		oddThread.start();
	}

}

class Even implements Runnable {

	@Override
	public void run() {
		int evenNum = 2;
		while (true) {
			System.out.println(Thread.currentThread().getName() + "---->" + evenNum);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			evenNum += 2;
			if (evenNum == 30)
				break;
		}
	}
}

class Odd implements Runnable {

	@Override
	public void run() {
		int oddNum = 1;
		while (true) {
			
			System.out.println(Thread.currentThread().getName() + "---->" + oddNum);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			oddNum += 2;
			if (oddNum == 31)
				break;

		}

	}

}