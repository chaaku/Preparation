package Second_Inning;

import java.util.HashMap;

// https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
// https://medium.com/@krishankantsinghal/my-first-blog-on-medium-583159139237
class Node {
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {

	final int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int getValue(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			// remove(n);
			// setHead(n);
			return n.value;
		}
		
		else {
			// connect to DB
			// pass the key and then get the value if present else return -1
		}

		return -1;
	}

	public void remove(Node n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}

	}

	public void setHead(Node n) {
		n.next = head;
		n.pre = null;

		if (head != null)
			head.pre = n;

		head = n;
		if (end == null)
			end = head;
	}

	public void putEntry(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
				old.value = value;
				remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		LRUCache lrucache = new LRUCache(3);
		lrucache.putEntry(1, 1);
		lrucache.putEntry(10, 15);
		lrucache.putEntry(15, 10);
		lrucache.putEntry(10, 16);
		lrucache.putEntry(12, 15);
		lrucache.putEntry(18, 10);
		lrucache.putEntry(13, 16);

		System.out.println(lrucache.getValue(10));
		System.out.println(lrucache.getValue(12));
		System.out.println(lrucache.getValue(18));

	}

}