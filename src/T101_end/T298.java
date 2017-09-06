package T101_end;

public class T298 {
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private int helper(TreeNode root, int[] max) {
		int result = 0;
		if (root == null)
			return result;
		result = 1;
		if (root.left != null) {
			int left = helper(root.left, max);
			if (root.val + 1 == root.left.val && left + 1 > result)
				result = left + 1;
		}
		if (root.right != null) {
			int right = helper(root.right, max);
			if (root.val + 1 == root.right.val && right + 1 > result)
				result = right + 1;
		}
		if (result > max[0])
			max[0] = result;
		return result;
	}
	
	public int longestConsecutive(TreeNode root) {
		int[] max = new int[1];
		helper(root, max);
		return max[0];
	}
	
	public static void main(String[] args) {
		T298 t298 = new T298();
		//testcase 1
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.right = n3;
		n3.left = n2;
		n3.right = n4;
		n4.right = n5;
		
//		//testcase 2
//		TreeNode n1 = new TreeNode(2);
//		TreeNode n2 = new TreeNode(3);
//		TreeNode n3 = new TreeNode(2);
//		TreeNode n4 = new TreeNode(1);
//		n1.right = n2;
//		n2.left = n3;
//		n3.left = n4;
		System.out.println(t298.longestConsecutive(n1));
	}

}
