package T460;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	
	// a doubly linked list
	public static class Node {
		int count;
		LinkedHashSet<Integer> keys;
		Node pre, next;
		
		public Node(int c) {
			count = c;
			keys = new LinkedHashSet<Integer>();
		}
		
		public void remove(int key) {
			keys.remove(key);
		}
		
		public boolean isEmpty() {
			return keys.isEmpty();
		}
		
		public void add(int key) {
			keys.add(key);
		}
		
		public int deleteLR() {
			Iterator<Integer> it = keys.iterator();
			int item = it.next();
			keys.remove(item);
			return item;
		}
	}
	
	private int capacity;
	// the head of the doubly linked list.
	private Node head; 
	private Map<Integer, Integer> mapCache;
	private Map<Integer, Node> nodeMap;
	
	public LFUCache(int c) {
		capacity = c;
		mapCache = new HashMap<Integer, Integer>();
		nodeMap = new HashMap<Integer, Node>();
	}
	
	public int get(int key) {
		if (!mapCache.containsKey(key))
			return -1;
		int value = mapCache.get(key);
		incCountOnKey(key);
		return value;
	}
	
	public void set(int key, int value) {
		if (capacity == 0) return;
		if (mapCache.containsKey(key))
			incCountOnKey(key);
		else {
			if (mapCache.size() == capacity)
				deleteLF();
			createNewKey(key);
		}
		mapCache.put(key, value);
	}
	
	private void deleteLF() {
		int key = head.deleteLR();
		if (head.isEmpty())
			deleteNodeFromList(head);
		mapCache.remove(key);
		nodeMap.remove(key);
	}
	
	private void createNewKey(int key) {
		if (head == null)
			head = new Node(1);
		if (head.count != 1) {
			Node node = new Node(1);
			addNodeBeforeHead(node);
		}
		head.add(key);
		nodeMap.put(key, head);
	}
	
	private void addNodeBeforeHead(Node node) {
		node.next = head;
		head.pre = node;
		head = node;
	}
	
	private void incCountOnKey(int key) {
		Node node = nodeMap.get(key);
		Node next = null;
		if (node.next == null || node.next.count != node.count + 1) {
			next = new Node(node.count + 1);
			next.add(key);
			addNodeAfter(node, next);
		}
		else {
			next = node.next;
			next.add(key);
		}
		nodeMap.put(key, next);
		deleteKeyFromNode(key, node);
	}
	
	private void addNodeAfter(Node after, Node node) {
		node.next = after.next;
		node.pre = after;
		after.next = node;
	}
	
	private void deleteKeyFromNode(int key, Node node) {
		node.remove(key);
		if (node.isEmpty())
			deleteNodeFromList(node);
	}
	
	private void deleteNodeFromList(Node node) {
		if (node == head) {
			head = head.next;
			if (head != null) head.pre = null;
			return;
		}
		if (node.pre != null) node.pre.next = node.next;
		if (node.next != null) node.next.pre = node.pre;
	}
	
	
	public static void main(String[] args) {
		int capacity = 0;
		LFUCache cache = new LFUCache(capacity);
		cache.set(0, 0);
		System.out.println(cache.get(0));
	}

}
