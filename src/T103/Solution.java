package T103;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		List<TreeNode> preLevel = null;
		List<TreeNode> curLevel = new ArrayList<TreeNode>();
		curLevel.add(root);
		boolean reverse = false;
		while (curLevel.size() > 0) {
			LinkedList<Integer> resultRow = new LinkedList<Integer>();
			for (int i = 0; i < curLevel.size(); i ++)
				if (!reverse) resultRow.addLast(curLevel.get(i).val);
				else resultRow.addFirst(curLevel.get(i).val);
			result.add(resultRow);
			preLevel = curLevel;
			curLevel = new ArrayList<TreeNode>();
			for (int i = 0; i < preLevel.size(); i ++) {
				TreeNode node = preLevel.get(i);
				if (node.left != null)
					curLevel.add(node.left);
				if (node.right != null)
					curLevel.add(node.right);
			}
			reverse = !reverse;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println(new Solution().zigzagLevelOrder(node1));
	}

}
