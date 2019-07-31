package Multithreading;

public class ZeroOddEvenThreadLockClass {
	protected int threadSequence = 0;

	public static void main(String[] args) {
		ZeroOddEvenThreadLockClass mtt = new ZeroOddEvenThreadLockClass();
		mtt.printSequenceWithThreads();
	}

	public void printSequenceWithThreads() {

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				try {
					int i = 1;
					for (i = 1; i <= 10;) {
						if (threadSequence == 0) {
							System.out.println(Thread.currentThread().getName() + "---->" + +0);
							if (i % 2 == 0) {
								threadSequence = 2;
							} else {
								threadSequence = 1;
							}
							i++;
						}
						Thread.sleep(100);
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				try {
					int i = 1;
					for (i = 1; i <= (10 * 2);) {
						if (threadSequence == 1) {
							System.out.println(Thread.currentThread().getName() + "---->" + i);
							threadSequence = 0;
							i = i + 2;
						}
						Thread.sleep(100);
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};

		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				try {
					int i = 2;
					for (i = 2; i <= (10 * 2);) {
						if (threadSequence == 2) {
							System.out.println(Thread.currentThread().getName() + "---->" + i);
							threadSequence = 0;
							i = i + 2;
						}
						Thread.sleep(100);
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};

		Thread t1 = new Thread(r1, "ZERO-THREAD");
		Thread t2 = new Thread(r2, "ODD-THREAD");
		Thread t3 = new Thread(r3, "EVEN-THREAD");

		t1.start();
		t2.start();
		t3.start();
	}

}