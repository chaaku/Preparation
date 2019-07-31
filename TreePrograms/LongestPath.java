package TreePrograms;

import java.util.ArrayList;
import java.util.Collections;

public class LongestPath {

	class Node { // tree node
		int id;
		Node left, right;

		Node(int id) {
			this.id = id;
		}

		Node(int id, Node left, Node right) {
			this(id);
			this.left = left;
			this.right = right;
		}
	}

	final Node root; // tree root

	class NodeList extends ArrayList<Node> { // list of nodes
		NodeList() {
		}

		NodeList(NodeList nl) { // copy constructor
			super(nl);
		}
	}

	class NodeListList extends ArrayList<NodeList> { // list of node lists
	}

	class Distance implements Comparable<Distance> { // distance between two nodes
		int dist;
		Node from, to;

		Distance(int dist, Node from, Node to) {
			this.dist = dist;
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Distance l) { // of Comparable
			return l.dist - dist;
		}
	}

	LongestPath() { // constructor
		root = // create test tree
				new Node(1, new Node(2, new Node(4), new Node(5, null, new Node(6))), new Node(3, new Node(7), null));
	}

	void traverse(Node n, NodeList nl, NodeListList nll) { // traverse tree recursively
		if (n != null) { // no leaf
			nl.add(n); // add node to current node list
			nll.add(new NodeList(nl)); // save current node list
			traverse(n.left, nl, nll); // left child
			traverse(n.right, nl, nll); // right child
			nl.remove(nl.size() - 1); // remove node from current node list
		}
	}

	Distance distance(NodeList nlFrom, NodeList nlTo) { // distance between two nodes
		final int L = Math.min(nlFrom.size(), nlTo.size());
		int i = 0;
		while (i < L && nlFrom.get(i) == nlTo.get(i))
			i++; // skip to closest common ancestor
		int d = (nlFrom.size() - i) + (nlTo.size() - i); // distance
		Node from = nlFrom.get(nlFrom.size() - 1);
		Node to = nlTo.get(nlTo.size() - 1);
		return new Distance(d, from, to);
	}

	void solve() { // the solution
		NodeListList nll = new NodeListList(); // list of node lists
		traverse(root, new NodeList(), nll); // walk the tree
		ArrayList<Distance> dl = new ArrayList<Distance>(); // list of distances
		for (int i = 0; i < nll.size(); i++) { // calculate distances
			for (int j = i; j < nll.size(); j++) { // between all tree nodes
				dl.add(distance(nll.get(i), nll.get(j))); // add distance to list
			}
		}
		Collections.sort(dl); // sort list of distances

		for (Distance d : dl) { // print result

			System.out.print("distance(");
			System.out.print(d.from.id);
			System.out.print(",");
			System.out.print(d.to.id);
			System.out.print(") = ");
			System.out.print(d.dist);
			System.out.println();

			break;
		}
	}

	public static void main(String[] args) { // entry point
		LongestPath lp = new LongestPath(); // leave static context
		lp.solve(); // solution
	}

}