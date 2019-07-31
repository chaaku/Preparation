
import java.util.LinkedList;
import java.util.Random;

public class LinkedListPrograms {

	public static class Node {

		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		LinkedList<Node> l1 = new LinkedList<Node>();
		Node head = new Node(1);

		l1.add(head);

		head.next = new Node(4);
		head.next.next = new Node(7);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(11);
		head.next.next.next.next.next = new Node(18);

		System.out.println("List : ");
		printList(head);

		System.out.println("\nAfter reverse  using Iteraion: ");
		Node reverse = reverseLinkedListUsingIteration(head);
		printList(reverse);

		System.out.println("\nAfter reverse  using Recursion: ");
		Node reverse2 = reverseLinkedListUsingRecursion(reverse);
		printList(reverse2);

		System.out.println("\nAfter reverse  in Pair using iteration : ");
		Node reverse3 = reverseLinkedListInPairItr(reverse2);
		printList(reverse3);

		System.out.println("\nAfter reverse  in Pair using Recursion : ");
		Node reverse4 = reverseLinkedListInPairRec(reverse3);
		printList(reverse4);

		System.out.println("\nfindrandom :"+reverse4);
		
		System.out.println("\nnth Node from Last Node  : " + nthFromLastNode(reverse4, 3).value);
//
		System.out.println("\nModdle Node of the linkedlist is  : " + findMiddleNode1(reverse4).value);
//
//		Node reverse5 = sorted2LinkedList(head, head);
//		printList(head);

	}
	
	public int findrandom(Node start) {
	    Node curr = start;
	    int count = 1, result = 0, probability;
	    Random rand = new Random();

	    while (curr != null) {
	        probability = rand.nextInt(count) + 1;
	        if (count == probability)
	            result = curr.value;
	        count++;
	        curr = curr.next;
	    }
	    return result;
	}

	private static Node sorted2LinkedList(Node a, Node b) {

		Node result = null;

		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.value <= b.value) {
			result = a;
			result.next = sorted2LinkedList(a.next, b);
		} else {
			result = b;
			result.next = sorted2LinkedList(a, b.next);
		}
		return result;
	}

	// This function will find middle node in linkedlist
	public static Node findMiddleNode1(Node head) {
		Node slowPointer, fastPointer;
		slowPointer = fastPointer = head;
		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			if (fastPointer != null && fastPointer.next != null) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
		}

		return slowPointer;

	}

	// nth node from last
	public static Node nthFromLastNode(Node head, int n) {
		Node firstPtr = head;
		Node secondPtr = head;

		for (int i = 0; i < n; i++) {
			firstPtr = firstPtr.next;

		}

		while (firstPtr != null) {
			firstPtr = firstPtr.next;
			secondPtr = secondPtr.next;
		}

		return secondPtr;
	}

	public static Node reverseLinkedListInPairRec(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		// Lets take example of 5->6->7
		// Here head node is 5
		// Storing 6 in temp node, it will become our new head
		Node temp = head.next;

		// Putting link between 5->7
		head.next = temp.next;

		// putting link between 6->5
		temp.next = head;

		// recursively calling the function for node 7
		head.next = reverseLinkedListInPairRec(head.next);

		// returning new head
		return temp;
	}

	public static Node reverseLinkedListInPairItr(Node head) {

		Node temp = null;
		Node newHead = null;
		while (head != null && head.next != null) {

			if (temp != null) {
				// This is important step
				temp.next.next = head.next;
			}
			temp = head.next;
			head.next = temp.next;
			temp.next = head;

			if (newHead == null)
				newHead = temp;
			head = head.next;
		}
		return newHead;
	}

	public static Node reverseLinkedListUsingIteration(Node head) {

		// For first node, previousNode will be null
// 1->2->3->4->5->6->7
		if (head == null || head.next == null)
			return head;
		
		Node currentNode = head;
		Node previousNode = null;
		Node nextNode;

		while (currentNode != null) {
			nextNode = currentNode.next;
			// reversing the link
			currentNode.next = previousNode;
			// moving currentNode and previousNode by 1 node
			previousNode = currentNode;

			currentNode = nextNode;
		}
		return previousNode;

	}

	public static Node reverseLinkedListUsingRecursion(Node head) {

		if (head == null || head.next == null)
			return head;

		else {
			Node remaining = reverseLinkedListUsingRecursion(head.next);
			head.next.next = head;
			head.next = null;
			return remaining;
		}
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
