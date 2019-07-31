package ProblemSolvingBrainteaser;

import java.util.ArrayList;
import java.util.Collections;

class node {

	int data;
	node left, right;

	public node(int data) {
		this.data = data;
		left = right = null;
	}

}

public class DImeterOfTree {

	static node first;
	static node second;

	public static void main(String[] args) {

		node root = new node(40);
		root.left = new node(20);
		root.left.left = new node(10);
		root.left.right = new node(30);
		root.right = new node(80);
		root.right.left = new node(50);
		root.right.right = new node(90);
		root.right.left.left = new node(45);
		root.right.left.right = new node(60);

		DImeterOfTree d = new DImeterOfTree();
		printTree(root);
		System.out.println("\nDimeter iof tree is " + dimeterOfTree(root));

		System.out.print("\nMaximum distance having nodes: ");
		d.solve(root);

		int sum = 215;
		ArrayList<Integer> list = new ArrayList<>();
		if (rootToLeafSum(root, sum, list) == true)
			System.out.println("\nlist with required sum " + sum + " is :" + list);
		else
			System.out.println("No path possible");

	}

	class NodeList extends ArrayList<node> { // list of nodes
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
		node from, to;

		Distance(int dist, node from, node to) {
			this.dist = dist;
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Distance l) { // of Comparable
			return l.dist - dist;
		}
	}

	void traverse(node n, NodeList nl, NodeListList nll) { // traverse tree recursively
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
		node from = nlFrom.get(nlFrom.size() - 1);
		node to = nlTo.get(nlTo.size() - 1);
		return new Distance(d, from, to);
	}

	void solve(node root) { // the solution
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

			System.out.print("");
			System.out.print(d.from.data);
			System.out.print(", ");
			System.out.print(d.to.data);
			System.out.print("");

			break;
		}
	}

	private static boolean rootToLeafSum(node root, int sum, ArrayList<Integer> list) {
		// TODO Auto-generated method stub

		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				list.add(root.data);
				return true;
			} else
				return false;
		}

		if (rootToLeafSum(root.left, sum - root.data, list)) {
			list.add(root.data);
			return true;
		}
		if (rootToLeafSum(root.right, sum - root.data, list)) {
			list.add(root.data);
			return true;
		}
		return false;
	}

	private static int dimeterOfTree(node root) {
		// TODO Auto-generated method stub

		// https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
		// complexity = n2
		if (root == null)
			return 0;

		int lheight = heightOfTree(root.left);
		int rheight = heightOfTree(root.right);

		int ldimeter = dimeterOfTree(root.left);
		int rdimeter = dimeterOfTree(root.right);

		return Math.max((lheight + rheight + 1), Math.max(ldimeter, rdimeter));

	}

	private static int heightOfTree(node root) {
		// TODO Auto-generated method stub

		if (root == null)
			return 0;
		else
			return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
	}

	private static void printTree(node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;

		else if (root != null) {
			System.out.print(root.data + " ");
			printTree(root.left);
			printTree(root.right);
		}
	}

}
