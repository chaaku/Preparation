package JudgementDay;

import java.util.*;

public class SnakeAndLadder {

	// Java program to find minimum number of dice
	// throws required to reach last cell from first
	// cell of a given snake and ladder board

	// An entry in queue used in BFS
	static class qentry {
		int vertex;// Vertex number
		int moves;// Distance of this vertex from source
	}

	// This function returns minimum number of dice
	// throws required to Reach last cell from 0'th cell
	// in a snake and ladder game. move[] is an array of
	// size N where N is no. of cells on board If there
	// is no snake or ladder from cell i, then move[i]
	// is -1 Otherwise move[i] contains cell to which
	// snake or ladder at i takes to.
	static int getMinDiceThrows(int board[], int n) {
		int visited[] = new int[n];
		Queue<qentry> q = new LinkedList<>();
		qentry qe = new qentry();
		qe.vertex = 0;
		qe.moves = 0;

		// Mark the node 0 as visited and enqueue it.
		visited[0] = 1;
		q.add(qe);

		// Do a BFS starting from vertex at index 0
		while (!q.isEmpty()) {
			qe = q.remove();
			int v = qe.vertex;

			// If front vertex is the destination
			// vertex, we are done
			if (v == n - 1)
				break;

			// Otherwise dequeue the front vertex and
			// enqueue its adjacent vertices (or cell
			// numbers reachable through a dice throw)
			for (int i = v + 1; i <= (v + 6) && i < n; ++i) {
				
				// If this cell is already visited, then ignore
				if (visited[i] == 0) {
					// Otherwise calculate its distance and
					// mark it as visited
					qentry a = new qentry();
					a.moves = (qe.moves + 1);
					visited[i] = 1;

					// Check if there a snake or ladder at 'i'
					// then tail of snake or top of ladder
					// become the adjacent of 'i'
					if (board[i] != -1)
						a.vertex = board[i];
					else
						a.vertex = i;

					q.add(a);
				}
			}
		}

		// We reach here when 'qe' has last vertex
		// return the distance of vertex in 'qe'
		return qe.moves;
	}

	public static void main(String[] args) {
		// Let us construct the board given in above diagram
		int N = 100;
		int board[] = new int[N];
		for (int i = 0; i < N; i++)
			board[i] = -1;

		// Ladders
		board[2] = 21;
		board[4] = 7;
		board[10] = 25;
		board[19] = 28;
		board[29] = 98;

		// Snakes
		board[26] = 0;
		board[20] = 8;
		board[16] = 3;
		board[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(board, N));
	}
}