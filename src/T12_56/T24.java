package T12_56;
public class T24 {

	private static ListNode swapPairs(ListNode head) {
		if (head==null) return null;
		if (head.next==null) return head;
		ListNode second = head.next;
		ListNode third = second.next;
		second.next = head;
		head.next = swapPairs(third);
		return second;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
}



//public ListNode swapPairs(ListNode head) {
//	if (head==null) return null;
//	if (head.next==null) return head;
//	ListNode p1 = head, p2, pre = null, second = head.next;
//	while (p1!=null) {
//		if (p1.next==null) break;
//		p2 = p1.next.next;
//		ListNode tmp = p1.next;
//		tmp.next = p1;
//		p1.next = p2;
//		if (pre!=null) pre.next = tmp;
//		pre = p1;
//		p1 = p2;
//	}
//	return second;
//}
