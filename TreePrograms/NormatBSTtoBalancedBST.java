package TreePrograms;

import java.util.Vector;

public class NormatBSTtoBalancedBST {

	public static class Node {

		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(8);
		root.left.left = new Node(7);
		root.left.left.left = new Node(6);
		root.left.left.left.left = new Node(5);
		
		Vector<Node> vector = new Vector<Node>();
		putIntoVector(root, vector);

		int n = vector.size();
		root= balancedBST(vector, 0, n - 1);

		System.out.print("inorder traversal of balanced BST is : ");
		inOrder(root);
	}

	private static void putIntoVector(Node root, Vector<Node> vector) {

		if (root == null)
			return;

		putIntoVector(root.left, vector);
		vector.add(root);
		putIntoVector(root.right, vector);
	}

	private static Node balancedBST(Vector<Node> nodes, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node node = nodes.get(mid);

		node.left = balancedBST(nodes, start, mid - 1);
		node.right = balancedBST(nodes, mid + 1, end);

		return node;
	}
	
	private static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.value + " ");
		inOrder(root.right);

	}

}
