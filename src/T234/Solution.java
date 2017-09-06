package T234;

public class Solution {

	
	// reverse the first half of the list, then compare
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		ListNode end = head;
		int len = 1;
		while (end.next != null) {
			end = end.next;
			len ++;
		}
		if (len == 1) return true;
		int i = 0;
		ListNode p1 = null, p2 = head, p3 = head.next;
		while (i < len / 2) {
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
			i ++;
		}
		ListNode left = p1, right = p2;
		if ((len & 1) == 1) right = p3;
		while (left != null) {
			if (left.val != right.val) return false;
			left = left.next;
		    right = right.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		System.out.println(new Solution().isPalindrome(node1));
	}

}
