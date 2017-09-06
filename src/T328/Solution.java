package T328;

public class Solution {

	public ListNode oddEvenList(ListNode head) {
		if (head == null) return null;
		ListNode odd = head, even = head.next, evenHead = even, oddEnd = null;
		while (odd != null || even != null) {
			if (odd.next != null) odd.next = odd.next.next; 
			oddEnd = odd; odd = odd.next;
			if (odd == null) break;
			if (even.next != null) even.next = even.next.next; 
			even = even.next;
		}
		if (oddEnd != null) oddEnd.next = evenHead;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new Solution().oddEvenList(null);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

}
