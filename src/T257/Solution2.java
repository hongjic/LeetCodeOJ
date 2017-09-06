package T257;

import java.util.List;
import java.util.ArrayList;

/*
 * This solution generates path when exploring,
 * it may be faster than Solution
 */
public class Solution2 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private void explore(StringBuffer builder, List<String> results, TreeNode node) {
		if (node.left == null && node.right == null) {
			// reaches leaf node, and the leaf is already in builder
			results.add(builder.toString());
			return;
		}
		int start = builder.length();
		if (node.left != null) {
			builder.append("->").append(node.left.val);
			explore(builder, results, node.left);
			builder.delete(start, builder.length());
		}
		if (node.right != null) {
			builder.append("->").append(node.right.val);
			explore(builder, results, node.right);
			builder.delete(start, builder.length());
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> results = new ArrayList<String>();
		if (root == null) return results;
		StringBuffer builder = new StringBuffer(String.valueOf(root.val));
		explore(builder, results, root);
		return results;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 sol = new Solution2();
		TreeNode node1 = new TreeNode(1),
				node2 = new TreeNode(2),
				node3 = new TreeNode(3),
				node4 = new TreeNode(4),
				node5 = new TreeNode(5),
				node6 = new TreeNode(6),
				node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.right = node5;
		node2.left = node4;
		node5.right = node6;
		node5.left = node7;
		List<String> result = sol.binaryTreePaths(node1);
		for (int i = 0; i < result.size(); i ++)
			System.out.println(result.get(i));
	}

}
