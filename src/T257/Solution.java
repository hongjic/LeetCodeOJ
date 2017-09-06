package T257;

import java.util.List;
import java.util.ArrayList;

/*
 * This solution first generates all paths and 
 * transfer to a string every time it reaches leaf node.
 * Time Complexity is O(nlogn) 
 * Because you have to take the time for transfering into count
 * Maybe a better way to do this is to generate the string while exploring,
 * so that we don't have to cost time on the same node transfering. 
 */
public class Solution {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	
	private String transfer(List<Integer> list) {
		if (list == null || list.size() == 0) return "";
		StringBuffer builder = new StringBuffer(String.valueOf(list.get(0)));
		for (int i = 1; i < list.size(); i ++)
			builder.append("->").append(list.get(i));
		return builder.toString();
	}
	
	private void helper(List<String> results, List<Integer> list, TreeNode node) {
		list.add(node.val);
		if (node.left == null && node.right == null) 
			results.add(transfer(list));
		if (node.left != null)
			helper(results, list, node.left);
		if (node.right != null)
			helper(results, list, node.right);
		list.remove(list.size() - 1);
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> results = new ArrayList<String>();
		if (root == null) return results;
		helper(results, new ArrayList<Integer>(), root);
		return results;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
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
