package T92;

public class Solution {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode leftEnd = getNode(head, m - 1), reverse = getNode(head, m), 
				reverseEnd = getNode(head, n), rightStart = reverseEnd.next;
		reverseEnd.next = null;
		reverseEnd = reverse;
		reverse = reverseList(reverse);
		if (leftEnd != null) leftEnd.next = reverse;
		else head = reverse;
		reverseEnd.next = rightStart;
		return head;
	}
	
	private ListNode getNode(ListNode head, int position) {
		if (position == 0) return null;
		for (int i = 0; i < position - 1; i ++)
			head = head.next;
		return head;
	}
	
	private ListNode reverseList(ListNode head) {
		ListNode node = head, pre = null;
		while (node != null) {
			ListNode next = node.next;
			node.next = pre; pre = node; node = next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
		ListNode head = new Solution().reverseBetween(node1, 1, 2);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

}
