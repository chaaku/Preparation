package Try_1;

public class ZigZacArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.print("Initial Array :" + " ");
		
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		
		for (int i = 2; i < arr.length; i+=2) {
			swap(arr, i-1, i);
		}
		
		System.out.print("After conversion : " );
		for (int i : arr)
			System.out.print(i + " ");

	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
