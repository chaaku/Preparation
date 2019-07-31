package JudgementDay;

import java.util.Scanner;

public class Dijkstra {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		int e = sc.nextInt();

		int adjacencyMatrix[][] = new int[v][v];
		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();

			adjacencyMatrix[v1][v2] = weight;
			adjacencyMatrix[v2][v1] = weight;
		}
		dijkstra(adjacencyMatrix);

	}

	private static void dijkstra(int[][] adjacencyMatrix) {
		// TODO Auto-generated method stub

		int v = adjacencyMatrix.length;
		// System.out.println(v);
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];

		distance[0] = 0;
		for (int i = 1; i < v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < v - 1; i++) {
			// find distance with minimum vertex
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			// explore neighbour

			for (int j = 0; j < v; j++) {
				if (adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
					int newDistance = distance[minVertex] + adjacencyMatrix[minVertex][j];

					if (newDistance < distance[j])
						distance[j] = newDistance;
				}
			}

		}

		// print
		for (int i = 0; i < v; i++) {
			System.out.println(i + " " + distance[i]);
		}

	}

	private static int findMinVertex(int[] distance, boolean[] visited) {
		// TODO Auto-generated method stub

		int minVertex = -1;
		for (int i = 0; i < distance.length; i++) {
			if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
				minVertex = i;
			}
		}

		return minVertex;
	}

}

/*
 * 
 * 5 7 0 1 4 0 2 8 1 3 5 1 2 3 2 3 5 2 4 9 3 4 4
 * 
 */
