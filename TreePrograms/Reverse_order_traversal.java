package TreePrograms;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Reverse_order_traversal {

	public static class Node {

		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node root = createBinaryTree();

		reverseTree(root);

	}

	public static void reverseTree(Node root) {

		if (root == null)
			return;

		Stack<Node> stack = new Stack();
		Queue<Node> queue = new LinkedList();

		queue.add(root);

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			stack.push(tempNode);

			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}

		while (!stack.isEmpty())
			System.out.println(stack.pop().data);
	}

	public static Node createBinaryTree() {

		Node rootNode = new Node(40);

		Node node30 = new Node(30);

		Node node20 = new Node(20);

		Node node10 = new Node(10);

		Node node50 = new Node(50);

		Node node60 = new Node(60);

		Node node70 = new Node(70);

		rootNode.left = node20;

		rootNode.right = node60;

		node60.left = node50;

		node60.right = node70;

		node20.left = node10;

		node20.right = node30;

		return rootNode;
	}
}
