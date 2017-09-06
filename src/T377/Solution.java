package T377;

import java.util.Arrays;

public class Solution {

	private int[] memorization;
	
	public int combinationSum4(int[] nums, int target) {
		memorization = new int[target + 1];
		Arrays.fill(memorization, -1);
		memorization[0] = 1; 
		return search(nums, target);
	}
	
	private int search(int[] nums, int target) {
		if (memorization[target] != -1)
			return memorization[target];
		int res = 0, len = nums.length;
		for (int i = 0; i < len; i ++)
			if (target >= nums[i])
				res += search(nums, target - nums[i]);
		memorization[target] = res;
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = new int[] {3, 33, 333};
		int target = 10000;
		System.out.println(sol.combinationSum4(nums, target));
	}

}
