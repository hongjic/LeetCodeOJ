package T268;

public class Solution {

	public int missingNumber(int[] nums) {
		for (int i = 0; i < nums.length; i ++) {
			while (i != nums[i] && nums[i] != -1) 
				swap(nums, i, nums[i]);
		}
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] == -1) return i;
		return nums.length;
	}
	
	private void swap(int[] nums, int i, int j) {
		if (j == nums.length) nums[i] = -1;
		else {
			int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().missingNumber(new int[]{1,2}));
	}

}
