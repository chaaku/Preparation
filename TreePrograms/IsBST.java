package TreePrograms;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Date 04/11/2015
 * 
 * @author tusroy
 * 
 *         Youtube link - https://youtu.be/MILxfAbIhrE
 * 
 *         Given a binary tree, return true if it is binary search tree else
 *         return false.
 * 
 *         Solution Keep min, max for every recursion. Initial min and max is
 *         very small and very larger number. Check if root.data is in this
 *         range. When you go left pass min and root.data and for right pass
 *         root.data and max.
 * 
 *         Time complexity is O(n) since we are looking at all nodes.
 * 
 *         Test cases: Null tree 1 or 2 nodes tree Binary tree which is actually
 *         BST Binary tree which is not a BST
 */
public class IsBST {

	static class Node {

		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	private boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data <= min || root.data > max) {
			return false;
		}
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}

	public boolean isBSTIterative(Node root) {
		if (root == null) {
			return true;
		}

		Deque<Node> dq = new LinkedList<>();
		Node node = root;
		int prev = Integer.MIN_VALUE;
		int current;
		while (true) {
			if (node != null) {
				dq.addFirst(node);
				node = node.left;
			} else {
				if (dq.isEmpty()) {
					break;
				}
				node = dq.pollFirst();
				current = node.data;
				if (current < prev) {
					return false;
				}
				prev = current;
				node = node.right;
			}
		}
		return true;
	}

	public static void main(String args[]) {

		Node root = new Node(40);
		root.left = new Node(20);
		root.left.right = new Node(30);
		root.left.left = new Node(10);
		root.right = new Node(70);
		root.right.left = new Node(50);
		root.right.right = new Node(90);
		root.right.left.left = new Node(45);
		root.right.left.right = new Node(60);
		IsBST isBST = new IsBST();
		System.out.println(isBST.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(isBST.isBSTIterative(root));
	}
}