package T141;
public class Solution {

	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
		ListNode slow = head.next;
		if (slow == null) return false;
		ListNode fast = head.next.next;
		while (slow != null && fast != null && slow != fast) {
			slow = slow.next;
			if (fast.next == null) return false;
			fast = fast.next.next;
		}
		
		if (slow == null || fast == null) return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
//		node6.next = node3;
		System.out.println(new Solution().hasCycle(node1));
	}

}
