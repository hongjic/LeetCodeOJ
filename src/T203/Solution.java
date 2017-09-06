package T203;

public class Solution {

	public ListNode removeElements(ListNode head, int val) {
		ListNode node = head, pre = null;
		while (node != null) {
			if (node.val == val) {
				if (pre != null) pre.next = node.next;
				else {
					head = head.next; pre = null;
				}
			}
			else pre = node;
			node = node.next;
		}	
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(6);
		ListNode node2 = new ListNode(6);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(6);
		node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5; node5.next = node6; node6.next = node7;
		ListNode head = new Solution().removeElements(node1, 6);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

}
