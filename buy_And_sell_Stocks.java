import java.util.ArrayList;

public class buy_And_sell_Stocks {

	public class Interval {

		int buy, sell;
	}

	private void BuyAndSell(int[] price, int n) {
		// TODO Auto-generated method stub
		// Prices must be given for at least two days
		if (n <= 1)
			return;

		int maximumProfit = 0;

		ArrayList<Interval> al = new ArrayList<Interval>();

		int i = 0, count = 0;
		while (i < n - 1) {

			// Find Local Minima. Note that the limit is (n-1) as we are
			// comparing present element to the next element.
			while (i < n - 1 && price[i] >= price[i + 1])
				i++;

			// If we reached the end, break as no further solution possible
			if (i == n - 1)
				break;

			Interval e = new Interval();
			e.buy = i++; // Store the index of minima
			int a = price[i+1];
			// System.out.println("buy :"+e.buy);

			// Find Local Maxima. Note that the limit is (n-1) as we are
			// comparing to previous element
			while (i < n-1 && price[i] >= price[i - 1])
				i++;

			e.sell = i-1; // Store the index of maxima
			// System.out.print("sell :"+e.sell+"\n");
			int b = price[i - 1];
			maximumProfit = maximumProfit + (b - a);

			al.add(e);
			// Increment number of buy/sell
			count++;
		}
		System.out.println("maximumProfit: " + maximumProfit);
		if (count == 0)
			System.out.println("No Buy or sell");

		else {
			for (int j = 0; j < count; j++)
				System.out.println(
						"you may buy at : " + al.get(j).buy + "th day and sell at :" + al.get(j).sell + "th day.");
		}
		return;
	}

	public static void main(String[] args) {

		buy_And_sell_Stocks stock = new buy_And_sell_Stocks();

		int price[] = { 100, 123, 42, 31, 124, 125, 32, 245, 267, 889, 342 };
		int n = price.length;

		stock.BuyAndSell(price, n);

	}

}
