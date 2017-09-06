package Algorithms.AddTwoNumbers;

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
	}
	public String toString() {
		return Integer.toString(val) + (next == null ? "" : " --> " + next.toString());
	}
}

public class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode result = null, cur = null, pre = null;
		int add = 0;
		while (p1 != null || p2 != null || add > 0) {
			int val = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + add;
			cur = new ListNode(val%10);
			add = val/10;
			if (result == null) 
				result = cur;
			else 
				pre.next = cur;
			pre = cur;
			if (p1 != null) 
				p1 = p1.next;
			if (p2 != null)
				p2 = p2.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListNode n11 = new ListNode(5);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(3);
		ListNode n21 = new ListNode(5);
		ListNode n22 = new ListNode(6);
		ListNode n23 = new ListNode(4);
//		n11.next = n12; n12.next = n13;
//		n21.next = n22; n22.next = n23;
		ListNode result = addTwoNumbers(n11, n21);
		System.out.println(result.toString());
		
	}
}
