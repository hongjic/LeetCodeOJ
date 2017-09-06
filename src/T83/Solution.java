package T83;

public class Solution {
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode pre = head, node = head;
		while (node != null) {
			while (node != null && node.val == pre.val) 
				node = node.next;
			pre.next = node;
			pre = node;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode head = new Solution().deleteDuplicates(null);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}
}
