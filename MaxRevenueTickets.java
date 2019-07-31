import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxRevenueTickets {

	static PriorityQueue<Integer> pq;

	public MaxRevenueTickets(int length) {

		pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

	}

	private int calculate(int[] arr, int n) {
		// TODO Auto-generated method stub

		int revenue = 0;

		for (int i = 0; i < arr.length; i++)
			pq.offer(arr[i]);

		while (n > 0) {
			int temp = pq.poll();
			revenue = revenue + temp;
			pq.offer(--temp);
			n--;
		}

		return revenue;
	}

	public static void main(String[] args) {

		int[] windowsTickets = { 5, 1, 7, 10, 11, 9 };
		int noOfTickets = 5;

		MaxRevenueTickets max = new MaxRevenueTickets(noOfTickets);
		System.out.println("Maximum revenue : " + max.calculate(windowsTickets, noOfTickets));

	}

}
