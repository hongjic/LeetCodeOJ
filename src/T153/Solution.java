package T153;

public class Solution {
	
	// use binary search to find the pivot
	public int findMin(int[] nums) {
		int len = nums.length;
		return nums[findPivot(nums, 0, len - 1)];
	}
	
	private int findPivot(int[] nums, int left, int right) {
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[right] > nums[mid]) right = mid;
			else left = mid + 1;
		}
		return left;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().findMin(new int[]{9,4,5,6,7,8}));
	}

}
