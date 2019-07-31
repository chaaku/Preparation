package Sorting;

public class HeapSort {
	public static void main(String[] args) {
		int a[] = { 5, 3, 1, 54, 35 };
		sort(a);

		for (int i : a)
			System.out.print(i + " ");
	}

	static void sort(int[] a) {
		int n = a.length;

		// build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapify(a, n, i);
		}
		// one by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// swap root to last element
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;

			// recursively heapify the affected sub-tree
			maxHeapify(a, i, 0);
		}
	}

	static void maxHeapify(int[] a, int n, int root) {

		int largest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		// if left child is larger than root
		if (left < n && a[left] > a[largest])
			largest = left;

		// if right child is larger than largest so far
		if (right < n && a[right] > a[largest])
			largest = right;

		// if largest is not root
		if (largest != root) {

			int temp = a[largest];
			a[largest] = a[root];
			a[root] = temp;

			// recursively heapify the affected sub-tree
			maxHeapify(a, n, largest);

		}
	}
}
