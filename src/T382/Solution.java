package T382;

import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        ListNode node = head, res = null;
        int count = 1;
        while (node != null) {
            if (rand.nextInt(count ++) == 0)
                res = node;
            node = node.next;
        }
        return res.val;
    }

}
