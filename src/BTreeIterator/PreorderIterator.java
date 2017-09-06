package BTreeIterator;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PreorderIterator {
	
	private Stack<Status> stack;
	
	private static class Status {
		List<TreeNode> nodes;
		int index;
		Status() { 
			index = 0; 
			nodes = new ArrayList<TreeNode>();
		}
		void addNode(TreeNode node) {
			nodes.add(node);
		}
		TreeNode nodeAtIndex() {
			return nodes.get(index);
		}
		boolean isEmpty() {
			return nodes.size() == 0 ? true : false;
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int v) {val = v;}
	}
	
	public PreorderIterator(TreeNode root) {
		stack = new Stack<Status>();
		Status rootStatus = new Status();
		rootStatus.addNode(root);
		stack.push(rootStatus);
	}
	
	public TreeNode next() {
		if (stack.isEmpty()) return null;
		Status status = stack.peek();
		while (status.index >= status.nodes.size()) {
			stack.pop();
			if (stack.isEmpty()) return null;
			status = stack.peek();
		}
		TreeNode node = status.nodeAtIndex();
		Status sonStatus = new Status();
		if (node.left != null)
			sonStatus.addNode(node.left);
		if (node.right != null)
			sonStatus.addNode(node.right);
		if (!sonStatus.isEmpty()) stack.push(sonStatus);
		status.index ++;
		return node;
	}
	
	public List<TreeNode> all() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode node = next();
		while (node != null) {
			list.add(node);
			node = next();
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5),
				node2 = new TreeNode(3),
				node3 = new TreeNode(1),
				node4 = new TreeNode(4),
				node5 = new TreeNode(8),
				node6 = new TreeNode(6),
				node7 = new TreeNode(9);
		node1.left = node2;
		node2.left = node3;
		node2.right = node4;
		node1.right = node5;
		node5.left = node6;
		node5.right = node7;
		PreorderIterator it = new PreorderIterator(node1);
		TreeNode next = it.next();
		while (next != null) {
			System.out.println(next.val);
			next = it.next();
		}
	}

}
