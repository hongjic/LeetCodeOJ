package T107;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null) return res;
		List<TreeNode> pre = Arrays.asList(root);
		while (pre.size() > 0) {
			List<TreeNode> cur = new ArrayList<TreeNode>();
			List<Integer> curRes = new ArrayList<Integer>();
			for (int i = 0; i < pre.size(); i ++) {
				TreeNode father = pre.get(i);
				curRes.add(father.val);
				if (father.left != null) cur.add(father.left);
				if (father.right != null) cur.add(father.right);
			}
			res.addFirst(curRes);
			pre = cur;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2; node1.right = node3;
		node3.left = node4; node3.right = node5;
		List<List<Integer>> res = new Solution().levelOrderBottom(node1);
		for (int i = 0; i < res.size(); i ++) {
			for (int j = 0; j < res.get(i).size(); j ++) 
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}

}
