package Find2Intervals;

public class Solution {

	public int find2Itervals(int[] nums, int k) {
		int len = nums.length;
		int[] sum = new int[len];
		int[] maxSumLeft = new int[len];
		int[] maxSumRight = new int[len];
		// sum[i] means the interval end at i
		for (int i = 0; i < k; i ++)
			sum[k - 1] += nums[i];
		for (int i = k; i < len; i ++)
			sum[i] = sum[i - 1] + nums[i] - nums[i - k ];
		// maxsumLeft[i] means the max interval of [0..i] 
		maxSumLeft[k - 1] = sum[k - 1];
		for (int i = k; i < len; i ++) {
			maxSumLeft[i] = Math.max(sum[i], maxSumLeft[i - 1]);
		}
		// maxSumright[i] means the max interval of [i..len- 1]
		maxSumRight[len - k] = sum[len - 1];
		for (int i = len - k - 1; i >= k - 1; i --)
			maxSumRight[i] = Math.max(sum[i + k - 1], maxSumRight[i + 1]);

		int max = 0;
		// partition begins here
		for (int i = k; i < len - k + 1; i ++) {//i is the second part's head
			if (maxSumLeft[i - 1] + maxSumRight[i] > max)
				max = maxSumLeft[i - 1] + maxSumRight[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = new int[] { 1,6,6,4,8,5,4,8,7 };
		int k = 2;
		System.out.println(sol.find2Itervals(nums, k));
	}

}
