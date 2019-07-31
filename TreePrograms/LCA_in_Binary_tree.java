package TreePrograms;

public class LCA_in_Binary_tree {

	public static class Node {

		int data;
		Node left;
		Node right;

		Node(int data) {

			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node root = createBinarytree();

		Node a = new Node(10);
		Node b = new Node(5);
		System.out.println(lowestCommonAncestor(root, a, b).data);

	}

	public static Node lowestCommonAncestor(Node root, Node a, Node b) {

		if (root == null)
			return null;

		if (root.data == a.data || root.data == b.data)
			return root;
			

		Node left = lowestCommonAncestor(root.left, a, b);
		Node right = lowestCommonAncestor(root.right, a, b);

		if (left != null && right != null)
			return root;

		else if (left == null && right == null)
			return null;
		
		else if (left == null)
			return right;
		else
			return left;

	}

	public static Node createBinarytree() {

		Node rootNode = new Node(40);

		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node50 = new Node(50);
		Node node60 = new Node(60);
		Node node70 = new Node(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node10.left = new Node(5);

		node60.left = node50;
		node60.right = node70;

		node50.right = new Node(55);

		return rootNode;
	}
}
