package T437;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	private int count;
	
	public int pathSum(TreeNode root, int sum) {
		count = 0;
		traverse(root, 0, new ArrayList<Integer>(), sum);
		return count;
	}
	
	private void traverse(TreeNode root, int sum, List<Integer> sums, int target) {
		if (root == null) return;
		int cur = sum + root.val;
		if (cur == target) count ++;
		for (int i = 0; i < sums.size(); i ++)
			if (cur - sums.get(i) == target) count ++;
		sums.add(cur);
		traverse(root.left, cur, sums, target);
		traverse(root.right, cur, sums, target);
		sums.remove(sums.size() - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode node1 = new TreeNode(10);
//		TreeNode node2 = new TreeNode(5);
//		TreeNode node3 = new TreeNode(-3);
//		TreeNode node4 = new TreeNode(3);
//		TreeNode node5 = new TreeNode(2);
//		TreeNode node6 = new TreeNode(11);
//		TreeNode node7 = new TreeNode(3);
//		TreeNode node8 = new TreeNode(-2);
//		TreeNode node9 = new TreeNode(1);
//		node1.left = node2; node1.right = node3;
//		node2.left = node4; node2.right = node5;
//		node3.right = node6; node4.left = node7;
//		node4.right = node8; node5.right = node9;
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(-2);
		TreeNode node3 = new TreeNode(-3);
		node1.left = node2; node1.right = node3;
		System.out.println(new Solution().pathSum(node1, -1));
	}

}
