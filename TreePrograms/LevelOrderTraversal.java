package TreePrograms;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static class TreeNode {

		TreeNode left;
		TreeNode right;
		int data;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(30);
		root.left.left = new TreeNode(10);
		root.right = new TreeNode(70);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(90);
		root.right.left.left = new TreeNode(45);
		root.right.left.right = new TreeNode(60);

		TreeNode root1 = new TreeNode(40);

		// levelOrderOrBFS(root1);
		System.out.println("Largest in Binary Tree : " + largest(root));
		// System.out.print("Largest in Binary Tree : ");

		LeafNodes(root);
		TreeNode a = new TreeNode(70);
		TreeNode b = new TreeNode(50);
		// System.out.println("Lowest Common Ancestor :
		// "+lowestCommonAncestor(root,a,b).data);
		// System.out.println("leafNodes are : "+LeafNodes(root).data);

	}

	private static void LeafNodes(TreeNode root) {
		// TODO Auto-generated method stub

		if (root == null)
			return;

		if (root.left == null && root.right == null)
			System.out.println(root.data);

		if (root.left != null)
			LeafNodes(root.left);

		if (root.right != null)
			LeafNodes(root.right);
	}

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		// TODO Auto-generated method stub

		if (root == null)
			return null;

		if (root.data == a.data || root.data == b.data)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, a, b);
		TreeNode right = lowestCommonAncestor(root.right, a, b);

		if (left != null && right != null)
			return root;
		
		if (left == null)
			return right;
		else
			return left;

	}

	private static int largest(TreeNode root) {
		// TODO Auto-generated method stub

		if (root == null)
			return 0;

		int left, right, max = 0;

		if (root != null) {

			int value = root.data;
			left = largest(root.left);
			right = largest(root.right);

			max = Math.max(left, right);

			if (value > max)
				max = value;
		}
		return max;
	}

	private static void levelOrderOrBFS(TreeNode root) {
		// TODO Auto-generated method stub

		System.out.print("Level order traversal of tree is : ");
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			System.out.println(root.data);

		else {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);

			while (!q.isEmpty()) {
				TreeNode temp = q.poll();
				System.out.print(temp.data + " ");

				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
	}

}
