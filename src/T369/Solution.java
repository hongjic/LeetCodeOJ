package T369;

public class Solution {

	public ListNode plusOne(ListNode head) {
		int first = recursive(head);
		if (first > 0) {
			ListNode node = new ListNode(first);
			node.next = head;
			head = node;
		}
		return head;
	}
	
	private int recursive(ListNode head) {
		if (head.next == null) {
			head.val ++;
			int res = head.val / 10;
			head.val = head.val % 10;
			return res;
		}
		head.val += recursive(head.next);
		int res = head.val / 10;
		head.val = head.val % 10;
		return res;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(9);
		node1.next = node2; node2.next = node3;
		ListNode head = new Solution().plusOne(node1);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}
}
