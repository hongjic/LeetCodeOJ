package T34;

public class Solution {

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) return new int[] {-1, -1};
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) left = mid + 1;
			else right = mid;
		}
		if (nums[left] != target) return new int[] {-1, -1};
		int i = left; 
		right = nums.length - 1;
		while (left < right) {
			int mid = (left + right + 1) / 2;
			if (nums[mid] > target) right = mid - 1;
			else left = mid;
		}
		return new int[] {i, left};
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {};
		int target = 5;
		int[] res = new Solution().searchRange(nums, target);
		System.out.println(res[0] + ", " + res[1]);
	}

}
