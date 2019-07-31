package Second_Inning;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExampleImpl {

	public static void main(String... args) throws InterruptedException, ExecutionException {

		// creating thread pool to execute task which implements Callable.
		// There will be a single thread working on this task

		ExecutorService es = Executors.newSingleThreadExecutor();
/*
 * A {@code Future} represents the result of an asynchronous
 * computation.  Methods are provided to check if the computation is
 * complete, to wait for its completion, and to retrieve the result of
 * the computation.  The result can only be retrieved using method
 * {@code get} when the computation has completed, blocking if
 * necessary until it is ready.
 * 
 */
		Future<Long> result = es.submit(new FactorialCalculator(10));
		long factorialof10 = result.get();
		
		System.out.println("factorial of 10 is : " + factorialof10);
	}

}

class FactorialCalculator implements Callable<Long> {
	private int number;

	public FactorialCalculator(int number) {
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		return factorial(number);
	}

	private long factorial(int n) throws InterruptedException {
		// System.out.println("Caluculating factorial for input : "+n);
		long result = 1;
		while (n != 0) {
			result = n * result;
			n = n - 1;
			Thread.sleep(100);
		}

		return result;
	}

}