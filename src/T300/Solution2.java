package T300;

import java.util.Arrays;

public class Solution2 {

	// follow up: O(nlogn) Solution
	// this algorithm can only find one LIS combination, and return the length.
	public int lengthOfLIS(int[] nums) {
		int [] f = new int[nums.length];
		int len = 0;
		 
		for (int x: nums) {
			int i = Arrays.binarySearch(f, 0, len, x);
			if (i < 0) i = -(i + 1);
			f[i] = x;
			if (i == len) len ++;
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution2().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
	}

}
