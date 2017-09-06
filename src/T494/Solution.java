package T494;

public class Solution {

	private int ans;
	
	public int findTargetSumWays(int[] nums, int S) {
		ans = 0;
		helper(nums, 0, 0, S);
		return ans;
	}
	
	private void helper(int[] nums, int index, int sum, int S) {
		if (index == nums.length) {
			if (sum == S) ans ++;
			return;
		}
		helper(nums, index + 1, sum + nums[index], S);
		helper(nums, index + 1, sum - nums[index], S);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,1,1,1,1};
		int S = 3;
		System.out.println(new Solution().findTargetSumWays(nums, S));
	}

}
