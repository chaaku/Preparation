package ProblemSolvingBrainteaser;

import java.util.LinkedList;

public class RotateLinkedListWithGivenNode {

	static node head;

	public static class node {

		int value;
		node next;

		node(int value) {
			this.value = value;
		}
	}

	public static void main(String args[]) {

		LinkedList<node> l1 = new LinkedList<node>();
		head = new node(1);

		l1.add(head);
		head.next = new node(4);
		head.next.next = new node(13);
		head.next.next.next = new node(6);
		head.next.next.next.next = new node(19);
		head.next.next.next.next.next = new node(18);

		System.out.print("List : ");
		printlist(head);

		System.out.print("\nList after rotating : ");
		rotate(2);
		printlist(head);

		System.out.print("\nList after reversing : ");
		reverse(head);

	}

	private static void reverse(node head2) {
		// TODO Auto-generated method stub

		if (head2 == null)
			return;

		reverse(head2.next);

		System.out.print(head2.value + " ");

	}

	// 1 4 13 6 19 18
	private static void rotate(int k) {
		if (k == 0)
			return;

		// Let us understand the below code for example k = 4
		// and list = 10->20->30->40->50->60.
		node current = head;

		// current will either point to kth or NULL after this
		// loop. current will point to node 40 in the above example
		int count = 1;
		while (count < k && current != null) {
			current = current.next;
			count++;
		}

		// If current is NULL, k is greater than or equal to count
		// of nodes in linked list. Don't change the list in this case
		if (current == null)
			return;

		// current points to kth node. Store it in a variable.
		// kthNode points to node 40 in the above example
		node kthNode = current;

		// current will point to last node after this loop
		// current will point to node 60 in the above example
		while (current.next != null)
			current = current.next;

		// Change next of last node to previous head
		// Next of 60 is now changed to node 10

		current.next = head;

		// Change head to (k+1)th node
		// head is now changed to node 50
		head = kthNode.next;

		// change next of kth node to null
		kthNode.next = null;

	}

	private static void printlist(node head) {
		// TODO Auto-generated method stub
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}

	}

}