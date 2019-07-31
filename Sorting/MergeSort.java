package Sorting;

public class MergeSort {

	public static void main(String[] args) {

		int a[] = { 14, 24, 17, 1, 32, 4, 6, 8, 26, 18, 95 };
		int p = 0, r = a.length - 1;
		mergesort(a, p, r);

		for (int i : a)
			System.out.print(i + " ");

	}

	static void mergesort(int a[], int p, int r) {
		int q;
		if (p < r) {
			q = (int) Math.floor((p + r) / 2);
			mergesort(a, p, q);
			mergesort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

	static void merge(int a[], int p, int q, int r) {
		int b[] = new int[a.length];
		int i, j, k;
		i = p;
		j = q + 1;
		k = 0;
		while (i <= q && j <= r) {
			if (a[i] < a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}

		while (i <= q)
			b[k++] = a[i++];

		while (j <= r)
			b[k++] = a[j++];

		for (i = r; i >= p; i--)
			a[i] = b[--k];
	}
}
