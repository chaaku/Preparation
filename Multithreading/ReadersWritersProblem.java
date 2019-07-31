package Multithreading;

public class ReadersWritersProblem {

	private int readers;

	public ReadersWritersProblem() {
		// TODO Auto-generated constructor stub
		this.readers = 0;
	}

	public void read(int reader) {

		synchronized (this) {
			this.readers++;
			System.out.println("reader " + readers + " started reading ");

		}

		final int delay = 5000;
		try {

			Thread.sleep((int) Math.random() * delay);

			} 
		catch (InterruptedException e) {
			}
		;

		synchronized (this) {
			System.out.println("Reader " + reader + " stopped reading");
			this.readers--;

			if (this.readers == 0) {
				this.notifyAll();
			}

		}

	}

	public synchronized void write(int writer) {

		while (this.readers != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
			;
		}

		System.out.println("Writer " + writer + " Started Writing");

		final int delay = 5000;

		try {
			Thread.sleep((int) Math.random() * delay);
		} catch (InterruptedException e) {
		}
		;

		System.out.println("Writer " + writer + " stopped Writing");
		this.notifyAll();
	}

	public static class Reader extends Thread {

		private static int readers = 0;
		private int reader;
		private ReadersWritersProblem readersWritersProblem;

		public Reader(ReadersWritersProblem readersWritersProblem) {
			this.readersWritersProblem = readersWritersProblem;
			this.reader = Reader.readers++;
		}

		@Override
		public void run() {
			while (true) {
				final int DELAY = 5000;
				try {
					Thread.sleep((int) (Math.random() * DELAY));
				} catch (InterruptedException e) {

				}
				this.readersWritersProblem.read(this.reader);
			}
		}
	}

	public static class Writer extends Thread {

		private static int writers = 0;
		private int writer;
		private ReadersWritersProblem ReadersWritersProblem;

		public Writer(ReadersWritersProblem readersWritersProblem) {
			this.ReadersWritersProblem = readersWritersProblem;
			this.writer = Writer.writers++;
		}

		@Override
		public void run() {
			while (true) {
				final int DELAY = 5000;
				try {
					Thread.sleep((int) (Math.random() * DELAY));
				} catch (InterruptedException e) {

				}
				this.ReadersWritersProblem.write(this.writer);
			}
		}
	}

	public static void main(String[] args) {

		ReadersWritersProblem rwp = new ReadersWritersProblem();

		int Readers = 10;
		int Writers = 1;

		for (int i = 0; i < Readers; i++) {
			new Reader(rwp).start();
		}

		for (int i = 0; i < Writers; i++) {
			new Writer(rwp).start();
		}
	}
}
