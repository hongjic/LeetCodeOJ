package T337;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	// recursive DP and memorization.
	private Map<TreeNode, Integer> maxSum = new HashMap<TreeNode, Integer>();
	
	public int rob(TreeNode root) {
		if (root == null) return 0;
		if (maxSum.containsKey(root)) return maxSum.get(root);
		// calculate max1 (rob root)
		int max1 = root.val;
		if (root.left != null)
			max1 += rob(root.left.left) + rob(root.left.right);
		if (root.right != null)
			max1 += rob(root.right.left) + rob(root.right.right);
		// calculate max2 (don't rob root)
		int max2 = rob(root.left) + rob(root.right);
		maxSum.put(root, Math.max(max1, max2));
		return maxSum.get(root);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode node1 = new TreeNode(3);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(3);
//		TreeNode node5 = new TreeNode(1);
//		node1.left = node2;
//		node1.right = node3;
//		node2.right = node4;
//		node3.right = node5;
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(1);
		node1.left = node2; node1.right = node3; node2.left = node4;
		node2.right = node5; node3.right = node6;
		System.out.println(new Solution().rob(node1));
	}

}
