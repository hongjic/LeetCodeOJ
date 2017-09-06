
public class FacebookInterview1 {

	private static class Node {
		Node next;
		Node down;
		int val;
		Node (int val) { this.val = val; }
	}
	
	private static class HeadEnd {
		Node head;
		Node end;
		HeadEnd ( Node head, Node end) {
			this.head = head;
			this.end = end;
		}
	}
	
	public HeadEnd serializeLinkedLists(Node head) {
		Node next = head.next;
		Node end = head;
		if (head.down != null) {
			HeadEnd he = serializeLinkedLists(head.down);
			head.next = he.head;
			he.end.next = next;
			end = he.end;
		}
		if (next != null) {
			HeadEnd he = serializeLinkedLists(next);
			end = he.end;
		}
		return new HeadEnd(head, end);
	}
	
	public static void main(String[] args) {
		FacebookInterview1 solution = new FacebookInterview1();
		Node node1 = new Node(1),
			node2 = new Node(2),
			node3 = new Node(3),
			node4 = new Node(4),
			node5 = new Node(5),
			node6 = new Node(6),
			node7 = new Node(7),
			node8 = new Node(8),
			node9 = new Node(9);
		node1.next = node2;
		node2.next = node8;
		node8.next = node9;
		node2.down = node3;
		node3.next = node6;
		node6.next = node7;
		node3.down = node4;
		node4.next = node5;
		Node root = solution.serializeLinkedLists(node1).head;
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}
}
