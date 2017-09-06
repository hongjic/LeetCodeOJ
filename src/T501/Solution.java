package T501;

import java.util.ArrayList;
import java.util.List;

/*
 * This should be the best solution because the space complexity here is O(logn), 
 * depend on the height of the tree.
 * but leetcode contains test cases that are not BST, so this solution can not pass on leetcode.
 * 2017/1/28
 */
public class Solution {

	private int maxf, curf;
	private Integer cur;
	
	public int[] findMode(TreeNode root) {
		List<Integer> modes = new ArrayList<Integer>();
		maxf = 0; cur = null; curf = 0;
		traverse(root, modes);
		int[] res = new int[modes.size()];
		for (int i = 0; i < modes.size(); i ++) res[i] = modes.get(i);
		return res;
	}
	
	private void traverse(TreeNode root, List<Integer> modes) {
		if (root == null) return;
		traverse(root.left, modes);
		if (cur == null) {
			cur = root.val;
			curf = 1;
		}
		else if (cur.intValue() != root.val) {
			cur = root.val;
			curf = 1;
		}
		else curf ++;
		if (curf > maxf) {
			maxf = curf;
			modes.clear();
			modes.add(cur);
		}
		else if (curf == maxf && cur != modes.get(modes.size() - 1)) modes.add(cur);
		traverse(root.right, modes);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(6);
		TreeNode node8 = new TreeNode(6);
		TreeNode node9 = new TreeNode(6);
		node5.left = node3;
		node3.left = node2;
		node2.left = node1;
		node3.right = node4;
		node5.right = node8;
		node8.left = node7;
		node8.right = node9;
		node7.left = node6;
		int[] res = new Solution().findMode(node5);
		for (int i = 0; i < res.length; i ++)
			System.out.print(res[i] + ", ");
	}

}
