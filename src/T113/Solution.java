package T113;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		traverse(root, 0, res, new LinkedList<Integer>(), sum);
		return res;
	}
	
	private void traverse(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> cur, int target) {
		if (root == null) return;
		sum += root.val;
		cur.addLast(root.val);
		if (sum == target && root.left == null && root.right == null) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int num: cur)
				list.add(num);
			res.add(list);
		}
		traverse(root.left, sum, res, cur, target);
		traverse(root.right, sum, res, cur, target);
		sum -= root.val;
		cur.removeLast();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		node1.left = node2; node1.right = node3;
		node2.left = node4; node3.left = node5;
		node3.right = node6; node4.left = node7;
		node4.right = node8; node6.left = node9;
		node6.right = node10;
		List<List<Integer>> res = new Solution().pathSum(node1, 22);
		for (int i = 0; i < res.size(); i ++) {
			for (int j = 0; j < res.get(i).size(); j ++)
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}

}
