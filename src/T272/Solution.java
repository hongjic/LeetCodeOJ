package T272;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	private void generateInorder(TreeNode root, ArrayList<Integer> arr) {
		if (root == null) return;
		generateInorder(root.left, arr);
		arr.add(root.val);
		generateInorder(root.right, arr);
	}
	
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (k == 0 || root == null) return res;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		generateInorder(root, arr);
		int index = Collections.binarySearch(arr, (int)target);
		if (index < 0) index = - index - 1;
		if (index >= arr.size()) index = arr.size() - 1;
		double min = Double.MAX_VALUE; int minIndex = index;
		for (int i = Math.max(index - 1, 0); i <= Math.min(index + 1, arr.size() - 1); i ++)
			if (Math.abs(target - arr.get(i)) < min) {
				min = Math.abs(target - arr.get(i));
				minIndex = i;
			}
		index = minIndex;
		
		res.add(arr.get(index)); k --;
		int left = index - 1, right = index + 1;
		while (k > 0) {
			if (right == arr.size() || (right < arr.size() && left >= 0 && Math.abs(target - arr.get(left)) < Math.abs(target - arr.get(right))))
				res.add(arr.get(left --));
			else res.add(arr.get(right ++));
			k --;
		}
		return res;
	}
	
	public static void main(String[] args) {
//		TreeNode node1 = new TreeNode(5);
//		TreeNode node2 = new TreeNode(3);
//		TreeNode node3 = new TreeNode(1);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(8);
//		TreeNode node6 = new TreeNode(7);
//		TreeNode node7 = new TreeNode(9);
//		TreeNode node8 = new TreeNode(10);
//		node1.left = node2;
//		node2.left = node3;
//		node2.right = node4;
//		node1.right = node5;
//		node5.left = node6;
//		node5.right = node7;
//		node7.right = node8;
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(8);
		node1.right = node2;
		double target = 3.0;
		int k = 1;
		List<Integer> res = new Solution().closestKValues(node1, target, k);
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i) + ", ");

	}

}
