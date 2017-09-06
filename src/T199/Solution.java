package T199;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		List<TreeNode> pre = new ArrayList<TreeNode>();
		pre.add(root);
		while (pre.size() > 0) {
			List<TreeNode> row = new ArrayList<TreeNode>();
			res.add(pre.get(pre.size() - 1).val);
			for (int i = 0; i < pre.size(); i ++) {
				if (pre.get(i).left != null) row.add(pre.get(i).left);
				if (pre.get(i).right != null) row.add(pre.get(i).right);
			}
			pre = row;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2; node1.right = node3; node2.right = node5; node3.right = node4;
		List<Integer> res = new Solution().rightSideView(node1);
		for (int i = 0; i < res.size(); i ++)
			System.out.print(res.get(i));
		
	}

}
