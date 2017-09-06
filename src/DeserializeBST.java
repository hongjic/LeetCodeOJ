/**
 * 
 * @author chenhongji
 * facebook interview
 * input: only preorder, try to use the feature of BST.
 */
public class DeserializeBST {

	private static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) { this.val = val; }
	}
	
	private static class Data {
		TreeNode root;
		int end;
		Data(TreeNode root, int end) {
			this.root = root;
			this.end = end;
		}
	}
	
	private Data deserializeBSTHelper(int[] nums, int index, int min, int max) {
		if (index >= nums.length || nums[index] <= min || nums[index] >= max) return null;
		TreeNode root = new TreeNode(nums[index]);
		int next = index + 1;
		Data son = deserializeBSTHelper(nums, next, min, root.val);
		
		if (son != null) {
			root.left = son.root;
			next = son.end + 1;
		}
		
		son = deserializeBSTHelper(nums, next, root.val, max);
		if (son != null) {
			root.right = son.root;
			next = son.end + 1;
		}
		
		return new Data(root, next - 1);
	}
	
	public TreeNode deserializeBST(int[] nums) {
		return deserializeBSTHelper(nums, 0, Integer.MIN_VALUE, Integer.MAX_VALUE).root;
	}
	
	public void printInorder(TreeNode root) {
		if (root == null) return;
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeserializeBST solution = new DeserializeBST();
		int[] nums = {10, 5, 3, 8, 7, 9, 13, 11, 15, 14};
		TreeNode root = solution.deserializeBST(nums);
		solution.printInorder(root);
	}

}
