package JudgementDay;

import java.util.Vector;

// https://github.com/evandrix/SPOJ/blob/master/DP_Main112/Solving-Traveling-Salesman-Problem-by-Dynamic-Programming-Approach-in-Java.pdf
public class TravellingSalesmanProblem {

	public static void main(String[] args) {

		int graph[][] = { { 0, 10, 15, 20 }, { 10, 0, 35, 25 }, { 15, 35, 0, 30 }, { 20, 25, 30, 0 } };
		int s = 0;
		int V = graph.length;
		System.out.println(travllingSalesmanProblem(graph, s, V));

	}

	private static int travllingSalesmanProblem(int[][] graph, int s, int V) {
		// TODO Auto-generated method stub

		Vector<Integer> vertex = new Vector<Integer>();

		for (int i = 0; i < V; i++) {
			if (i != s)
				vertex.add(i);
		}
		// store minimum weight Hamiltonian Cycle.
		int a[] = new int[V * V];
		int min_path = Integer.MAX_VALUE;
		do {

			// store current Path weight(cost)
			int current_pathweight = 0;

			// compute current path weight
			int k = s;
			for (int i = 0; i < vertex.size(); i++) {
				current_pathweight += graph[k][vertex.get(i)];
				k = vertex.get(i);
			}
			current_pathweight += graph[k][s];

			// update minimum
			min_path = Math.min(min_path, current_pathweight);

			// int []a = {vertex.get(0), vertex.get(vertex.size()-1)};

			for (int index = 0; index < vertex.size(); index++) {
				a[index] = vertex.get(index);

			}

		} while (next_permutation(a));
		return 0;
	}

	public static boolean next_permutation(int a[]) {
		for (int i = a.length - 2, j; i >= 0; i--) {
			if (a[i + 1] > a[i]) {
				for (j = a.length - 1; a[j] <= a[i]; j--)
					;
				swap(a, i, j);
				for (j = 1; j <= (a.length - i) / 2; j++)
					swap(a, i + j, a.length - j);
				return true;
			}
		}
		return false;
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
