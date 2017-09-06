package T138;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public RandomListNode copyRandomList(RandomListNode head) {
		 Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		 // create new node, and map them to the original nodes
		 RandomListNode node = head;
		 while (node != null) {
			 map.put(node, new RandomListNode(node.label));
			 node = node.next;
		 }
		 node = head;
		 while (node != null) {
			 map.get(node).next = node.next == null ? null : map.get(node.next);
			 map.get(node).random = node.random == null ? null : map.get(node.random);
			 node = node.next;
		 }
		 return map.get(head);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		RandomListNode node6 = new RandomListNode(6);
		RandomListNode node7 = new RandomListNode(7);
		RandomListNode node8 = new RandomListNode(8);
		RandomListNode node9 = new RandomListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node1.random = node3;
		node2.random = node9;
		node3.random = node5;
		node4.random = node1;
		node5.random = node7;
		node6.random = node6;
		node7.random = node2;
		node8.random = node4;
		node9.random = node8;
		RandomListNode head = new Solution().copyRandomList(node1);
	}

}
