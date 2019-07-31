
public class RearrangePositionInArray {

	// The function to rearrange an array in-place so that arr[i]
	// becomes arr[arr[i]]. int arr[] = { 3, 2, 0, 1 }; // 1 0 3 2  // arr[arr[i]].
	void rearrange(int arr[], int n) {
		// First step: Increase all values by (arr[arr[i]]%n)*n

		for (int i = 0; i < n; i++) {
			//System.out.println("Before :" + arr[i]);
			arr[i] += (arr[arr[i]] % n) * n;
	//		System.out.println("After :" + arr[i]);
		}
		for(int i:arr)
		System.out.print(i + " ");
		System.out.println();

	//	System.out.print("printing array\n");
		//printArr1(arr, n);
	//	System.out.print(".........\n");
		for (int i = 0; i < n; i++) {
			arr[i] /= n;
		}

	}

	// A utility function to print an array of size n
	static void printArr1(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	// A utility function to print an array of size n
	void printArr(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		RearrangePositionInArray rearrange = new RearrangePositionInArray();
		int arr[] = { 3, 2, 0, 1 }; // 1 0 3 2  // arr[arr[i]].
		int arr1[] = { 4, 2, 0, 1, 3 };

		int n = arr.length;
		int n1 = arr1.length;

		System.out.print("Given Array is : ");
		rearrange.printArr(arr, n);
		System.out.println();
		rearrange.rearrange(arr, n);

		rearrange.rearrange(arr1, n1);

		System.out.print("\nModified Array is : ");
		rearrange.printArr(arr, n);

		System.out.print("\nModified Array 1 is : ");
		rearrange.printArr(arr1, n1);
	}
}
