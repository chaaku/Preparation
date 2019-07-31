
public class Sort01And2s {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		int count0 = 0, count1 = 0, count2 = 0;

		for (int i : arr) {

			if (i == 0)
				count0++;
			else if (i == 1)
				count1++;
		}

		for (int i = 0; i < count0; i++)
			arr[i] = 0;

		for (int i = count0; i < count0 + count1; i++)
			arr[i] = 1;

		for (int i = count0 + count1; i < arr.length; i++)
			arr[i] = 2;

		for (int i : arr)
			System.out.println(i);

	}

}
