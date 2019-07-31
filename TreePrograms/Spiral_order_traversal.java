package TreePrograms;

import java.util.Stack;

public class Spiral_order_traversal {

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
		spiral(root);
	}

	public static void spiral(Node root) {

		if (root == null)
			return;

		Stack<Node> stack = new Stack();
		boolean direction = false;
		stack.push(root);

		while (!stack.isEmpty()) {
			Stack tempStack = new Stack();
			while (!stack.isEmpty()) {
				Node temp = stack.pop();
				System.out.println(temp.data);
				if (!direction) {
					if (temp.left != null)
						tempStack.push(temp.left);
					if (temp.right != null)
						tempStack.push(temp.right);
				} else {
					if (temp.right != null)
						tempStack.push(temp.right);
					if (temp.left != null)
						tempStack.push(temp.left);
				}
			}

			direction = !direction;
			stack = tempStack;
		}

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
