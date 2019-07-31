package ProblemSolvingBrainteaser;

import java.util.List;
import java.util.LinkedList;

public class MergeTwoSortedList {

	public static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {

		List<Node> l1 = new LinkedList<Node>();

		l1.add(new Node(5));
		l1.add(new Node(7));
		l1.add(new Node(9));
		l1.add(new Node(11));
		l1.add(new Node(13));

		List<Node> l2 = new LinkedList<Node>();

		// Null List
		// List<Node> l2 = new LinkedList<Node>();

		l2.add(new Node(1));
		l2.add(new Node(4));
		l2.add(new Node(8));
		l2.add(new Node(11));
		l2.add(new Node(12));
		l2.add(new Node(13));
		l2.add(new Node(14));

		List<Node> res = new LinkedList<Node>();
		Merge2List(l1, l2, res);

		for (Node i : res)
			System.out.println(i.data);
	}

	public static List Merge2List(List<Node> list1, List<Node> list2, List<Node> res) {
		// TODO Auto-generated method stub

		if (list1 == null)
			res = list2;
		if (list2 == null)
			res = list1;

		int m = list1.size();
		int n = list2.size();

		int i = 0, j = 0;

		while (i < m && j < n) {

			if (list1.get(i).data < list2.get(j).data)
				res.add(new Node(list1.get(i++).data));

			else
				res.add(new Node(list2.get(j++).data));
		}

		while (i < m)
			res.add(new Node(list1.get(i++).data));

		while (j < n)
			res.add(new Node(list2.get(j++).data));

		return res;

	}
}
