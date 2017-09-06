package T366;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	private boolean isLeaf(TreeNode root, List<Integer> leaves) {
		if (root.left == null && root.right == null) {
			leaves.add(root.val);
			return true;
		}
		if (root.left != null) {
			if (isLeaf(root.left, leaves)) 
				root.left = null;
		}
		if (root.right != null) {
			if (isLeaf(root.right, leaves))
				root.right = null;
		}
		return false;
	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		List<Integer> leaves = null;
		while (root.left != null || root.right != null) {
			leaves = new ArrayList<Integer>();
			isLeaf(root, leaves);
			result.add(leaves);
		}
		result.add(new ArrayList<Integer>(Arrays.asList(root.val)));
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		List<List<Integer>> leaves = new Solution().findLeaves(node1);
		for (int i = 0; i < leaves.size(); i ++) {
			for (int j = 0; j < leaves.get(i).size(); j ++)
				System.out.print(leaves.get(i).get(j) + ",");
			System.out.println();
		}
	}

}
