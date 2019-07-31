package TreePrograms;

public class ShortestPathBetween2Node {

	public static class Node {

		Node parent;

		public Node(Node parent) {
			this.parent = parent;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(null);
		Node node11 = new Node(root);
		Node node12 = new Node(root);
		Node node21 = new Node(node11);
		Node node22 = new Node(node11);
		Node node23 = new Node(node12);
		Node node24 = new Node(node12);
		Node node31 = new Node(node21);

		// System.out.println(getShortestPath(root, root));
		// System.out.println(getShortestPath(node21, node22));
		// System.out.println(getShortestPath(node31, node12));
		// System.out.println(getShortestPath(node31, root));
		// System.out.println(getShortestPath(node31, node12));
		System.out.println(getShortestPath(node31, node24));
	}

	public static int getShortestPath(Node first, Node second) {
		if (first == null || second == null) {
			throw new IllegalArgumentException("Input parameters should be not null");
		}
		if (first == second) {
			return 0;
		}
		int LevelOf1 = getLevel(first);
		int LevelOf2 = getLevel(second);
		int shortestPath = 0;

		while (LevelOf1 > LevelOf2) {
			first = first.parent;
			LevelOf1--;
			shortestPath++;
		}
		while (LevelOf2 > LevelOf1) {
			second = second.parent;
			LevelOf2--;
			shortestPath++;
		}
		while (first != second) {
			first = first.parent;
			second = second.parent;
			shortestPath += 2;
		}
		return shortestPath;
	}

	private static int getLevel(Node treeNode) {
		int level = 0;

		while (treeNode.parent != null) {
			treeNode = treeNode.parent;
			level++;
		}
		return level;
	}

}