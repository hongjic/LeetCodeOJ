package BTreeIterator;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InorderIterator {

	private Stack<TreeNode> stack;
	
	public static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int v) { val = v;}
	}
	
	public InorderIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	
	public TreeNode next() {
		if (stack.isEmpty()) return null;
		TreeNode node = stack.pop();
		TreeNode cur = node.right;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		return node;
	}
	
	public List<TreeNode> all() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		while (!stack.isEmpty())
			list.add(next());
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
		InorderIterator it = new InorderIterator(node1);
		TreeNode next = it.next();
		while (next != null) {
			System.out.println(next.val);
			next = it.next();
		}
	}

}
