package T198;

public class Solution {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		int[] f = new int[len];
		f[0] = nums[0];
		int max = f[0];
		for (int i = 1; i < len; i ++) {
			f[i] = nums[i];
			int maxLocal = 0;
			for (int j = 0; j <= i - 2; j ++)
				maxLocal = Math.max(maxLocal, f[j]);
			f[i] += maxLocal;
			max = Math.max(max, f[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1 };
		System.out.println(new Solution().rob(nums));
	}

}
