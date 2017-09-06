package T445;

public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int len1 = getLength(l1), len2 = getLength(l2);
		if (len1 < len2) {
			int t = len1; len1 = len2; len2 = t;
			ListNode l3 = l1; l1 = l2; l2 = l3;
		}
		int first = addTwoNumber(l1, l2, 0, len1 - len2);
		if (first > 0) {
			ListNode node = new ListNode(first);
			node.next = l1;
			l1 = node;
		}
			return l1;
	}
	
	private int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len ++; head = head.next;
		}
		return len;
	}
	
	private int addTwoNumber(ListNode l1, ListNode l2, int index, int d) {
		if (l1 == null) return 0;
		int res;
		if (index < d) {
			int add = addTwoNumber(l1.next, l2, index + 1, d);
			l1.val += add;
			res = l1.val / 10;
			l1.val = l1.val % 10;
		}
		else {
			int add = addTwoNumber(l1.next, l2.next, index + 1, d);
			l1.val += add + l2.val;
			res = l1.val / 10;
			l1.val = l1.val % 10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(3);
		node1.next = node2; node2.next = node3; node3.next = node4;
		ListNode node5 = new ListNode(7);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(4);
		node5.next = node6; node6.next = node7;
		ListNode head = new Solution().addTwoNumbers(node1, node5);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

}
