package T209;

public class Solution {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int len = nums.length;
		int i = 0, j = 0, min = Integer.MAX_VALUE, sum = 0;
		while (j < len && sum < s) {
			sum += nums[j];
			j ++;
		} // to j-1  sum >= s
		if (j == len && sum < s) return 0;
		j --; sum -= nums[j];
		while (j < len) {
			sum += nums[j];
			while (i <= j && sum - nums[i] >= s) {
				sum -= nums[i];
				i ++;
			}
			if (j - i + 1< min) 
				min = j - i + 1;
			j ++;
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int s = 3;
		int[] nums = new int[]{1,1};
		System.out.println(sol.minSubArrayLen(s, nums));
	}

}
