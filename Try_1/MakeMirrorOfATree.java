package Try_1;

public class MakeMirrorOfATree {

	private class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	void mirror(Node i_Node) {
		if (i_Node == null || (i_Node.right == null && i_Node.left == null)) {
			return;
		} else {
			switchChildren(i_Node);
			mirror(i_Node.left);
			mirror(i_Node.right);
		}
	}

	public void switchChildren(Node i_Nood) {
		if (i_Nood != null) {
			Node temp = i_Nood.left;
			i_Nood.left = i_Nood.right;
			i_Nood.right = temp;
		}
	}
}
