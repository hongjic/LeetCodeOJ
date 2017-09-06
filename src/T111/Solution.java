package T111;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {

	public int minDepth(TreeNode root) {
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> depth = new LinkedList<Integer>();
		if (root != null) {
			nodes.offer(root); depth.offer(1);
		}
		int curDepth = 0;
		while (!nodes.isEmpty()) {
			boolean leaf = true;
			TreeNode cur = nodes.poll(); curDepth = depth.poll();
			if (cur.left != null) {
				leaf = false;
				nodes.offer(cur.left); depth.offer(curDepth + 1);
			}
			if (cur.right != null) {
				leaf = false;
				nodes.offer(cur.right); depth.offer(curDepth + 1);
			}
			if (leaf) break;
		}
		return curDepth;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		node1.left = node2; node1.right = node3; node2.left = node4; node4.right = node5;
		node3.right = node6;
		System.out.println(new Solution().minDepth(node4));
	}

}
