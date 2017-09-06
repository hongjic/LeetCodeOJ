package T154;

public class Solution {

	// return the min value, not index
	// reduce this problem to the no duplicate minimum problem
	public int findMin(int[] nums) {
		int len = nums.length;
		int left = 0, right = len - 1;
		while (left < right) {
			while (left < right && nums[left] == nums[right]) right --;
			if (left == right) return nums[left];
			if (nums[right] > nums[left]) return nums[left];
			int mid = left + (right - left) / 2;
			if (nums[mid] >= nums[left]) left = mid + 1;
			else right = mid;
		}
		return nums[left];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().findMin(new int[]{1, 1, 1}));
	}

}
