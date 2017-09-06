package T82;

public class Solution {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		ListNode slow = head, fast = head.next, pre = null;
		while (fast != null) {
			boolean dup = false;
			while (fast != null && fast.val == slow.val) {
				dup = true;
				slow.next = fast.next;
				fast = fast.next;
			}
			if (dup) {
				if (pre != null) pre.next = fast;
				else head = fast;
			} else pre = slow;
			if (fast == null) break;
			slow = fast; fast = fast.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(3);
//		ListNode node6 = new ListNode(4);
//		ListNode node7 = new ListNode(5);
		node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
//		node5.next = node6; node6.next = node7;
		ListNode head = new Solution().deleteDuplicates(node1);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

}
