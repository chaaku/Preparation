package ProblemSolvingBrainteaser;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class TopViewNode {

	int value;
	TopViewNode left, right;

	public TopViewNode(int value) {
		this.value = value;
		left = right = null;
	}
}

class QItem {
	TopViewNode node;
	int hd;

	public QItem(TopViewNode n, int h) {
		node = n;
		hd = h;
	}
}

public class TopViewOfTree {

	TopViewNode root;

	public TopViewOfTree(TopViewNode n) {
		root = n;
	}

	public static void main(String[] args) {

		TopViewNode root = new TopViewNode(1);
		root.left = new TopViewNode(2);
		root.right = new TopViewNode(3);
		root.left.right = new TopViewNode(4);
		root.left.right.right = new TopViewNode(5);
		root.left.right.right.right = new TopViewNode(6);
		TopViewOfTree t = new TopViewOfTree(root);
		System.out.println("Following are nodes in top view of Binary Tree");
		t.printTopView();

	}

	private void printTopView() {
		// TODO Auto-generated method stub

		if (root == null)
			return;

		Queue<QItem> q = new LinkedList<QItem>();
		HashSet<Integer> hs = new HashSet<>();

		q.add(new QItem(root, 0));

		while (!q.isEmpty()) {

			QItem qi = q.remove();
			TopViewNode n = qi.node;
			int hd = qi.hd;

			if (!hs.contains(hd)) {
				System.out.println(n.value);
				hs.add(hd);
			}

			if (n.left != null)
				q.add(new QItem(n.left, hd - 1));

			if (n.right != null)
				q.add(new QItem(n.right, hd + 1));
		}
		/*
		 * Time Complexity of the above implementation is O(n) where n is number of
		 * nodes in given binary tree. The assumption here is that add() and contains()
		 * methods of HashSet work in O(1) time.
		 */
	}

}
