package T300;

import java.util.Arrays;

public class Solution {

	// O(n^2) solution
	public int lengthOfLIS(int[] nums) {
		int len = nums.length, max = 1;
		if (len == 0) return 0;
		int[] f = new int[len];
		Arrays.fill(f, 1);
		for (int i = 1; i < len; i ++) {
			for (int j = 0; j < i; j ++)
				if (nums[i] > nums[j]) 
					f[i] = Math.max(f[i], f[j] + 1);
			max = Math.max(max, f[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().lengthOfLIS(new int[]{}));
	}

}
