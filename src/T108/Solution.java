package T108;

public class Solution {

	public TreeNode sortedArrayToBST(int[] nums) {
		return rangeToBST(nums, 0, nums.length - 1);
	}
	
	private TreeNode rangeToBST(int[] nums, int left, int right) {
		if (left > right) return null;
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = rangeToBST(nums, left, mid - 1);
		root.right = rangeToBST(nums, mid + 1, right);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,5,6};
		TreeNode root = new Solution().sortedArrayToBST(nums);
		
	}

}
