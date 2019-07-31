package TreePrograms;

import java.util.ArrayList;

public class Path_from_root_to_leaf {

	public static class Node {

		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node rootNode = createBinaryTree();
		ArrayList<Integer> al = new ArrayList<Integer>();
		printal(rootNode, al);
	}

	public static void printal(Node root, ArrayList<Integer> al) {

		if (root == null)
			return;
		al.add(root.data);
		if (root.left == null && root.right == null) {
			System.out.println(al);
			return;
		} else {
			printal(root.left, new ArrayList<Integer>(al));
			printal(root.right, new ArrayList<Integer>(al));
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

		Node node5 = new Node(5);

		Node node55 = new Node(55);

		rootNode.left = node20;

		rootNode.right = node60;

		node60.left = node50;

		node60.right = node70;

		node20.left = node10;

		node20.right = node30;

		node10.left = node5;

		node50.right = node55;

		return rootNode;
	}
}
