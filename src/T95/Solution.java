package T95;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}
	
	private List<TreeNode> generateTrees(int left, int right) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (left > right) return res;
		if (left == right) return Arrays.asList(new TreeNode(left));
		
		for (int root = left; root <= right; root ++) {
			List<TreeNode> leftTrees = generateTrees(left, root - 1);
			List<TreeNode> rightTrees = generateTrees(root + 1, right);
			if (leftTrees.size() == 0 && rightTrees.size() == 0) res.add(new TreeNode(root));
			else if (leftTrees.size() == 0) {
				for (int i = 0; i < rightTrees.size(); i ++) {
					TreeNode node = new TreeNode(root);
					node.right = rightTrees.get(i);
					res.add(node);
				}
			}
			else if (rightTrees.size() == 0) {
				for (int i = 0; i < leftTrees.size(); i ++) {
					TreeNode node = new TreeNode(root);
					node.left = leftTrees.get(i);
					res.add(node);
				}
			}
			else {
				for (int i = 0; i < leftTrees.size(); i ++)
					for (int j = 0; j < rightTrees.size(); j ++) {
						TreeNode node = new TreeNode(root);
						node.left = leftTrees.get(i);
						node.right = rightTrees.get(j);
						res.add(node);
					}
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		List<TreeNode> res = new Solution().generateTrees(3);
		System.out.println(res.get(0).val);
		System.out.println(res.get(0).right.val);
		System.out.println(res.get(0).right.right.val);
		System.out.println();
		
		System.out.println(res.get(1).val);
		System.out.println(res.get(1).right.val);
		System.out.println(res.get(1).right.left.val);
		System.out.println();
		
		System.out.println(res.get(2).val);
		System.out.println(res.get(2).left.val);
		System.out.println(res.get(2).right.val);
		System.out.println();
		
		System.out.println(res.get(3).val);
		System.out.println(res.get(3).left.val);
		System.out.println(res.get(3).left.right.val);
		System.out.println();
		
		System.out.println(res.get(4).val);
		System.out.println(res.get(4).left.val);
		System.out.println(res.get(4).left.left.val);
	}
}
