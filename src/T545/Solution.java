package T545;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		appendLeftBoundary(res, root);
		appendLeaves(res, root, 0);
		appendRightBoundary(res, root);
		return res;
	}
	
	private void appendLeftBoundary(List<Integer> res, TreeNode node) {
		res.add(node.val);
		node = node.left;
		while (node != null) {
			if (node.left != null || node.right != null) res.add(node.val);
			if (node.left != null) node = node.left;
			else node = node.right;
		}
	}
	
	private void appendLeaves(List<Integer> res, TreeNode root, int depth) {
		if (root.left == null && root.right == null) {
			if (depth > 0) res.add(root.val);
			return;
		}
		if (root.left != null) appendLeaves(res, root.left, depth + 1);
		if (root.right != null) appendLeaves(res, root.right, depth + 1);
	}
	
	private void appendRightBoundary(List<Integer> res, TreeNode node) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(node.val);
		node = node.right;
		while (node != null) {
			if (node.left != null || node.right != null) stack.push(node.val);
			if (node.right != null) node = node.right;
			else node = node.left;
		}
		while (stack.size() > 1) {
			res.add(stack.pop());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		node1.right = node2;
		node2.left = node3;
		node2.right = node4;
		List<Integer> res = new Solution().boundaryOfBinaryTree(node1);
		for (int i = 0; i < res.size(); i ++)
			System.out.print(res.get(i) + " ");
	}

}
