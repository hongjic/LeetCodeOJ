package T486;

public class Solution {
	
	public boolean PredictTheWinner(int[] nums) {
		return helper(nums, 0, nums.length - 1, 0, 0, true);
	}
	
	private boolean helper(int[] nums, int left, int right, int score1, int score2, boolean player1) {
		if (left > right) 
			return score1 >= score2;
		
		if (player1) return helper(nums, left + 1, right, player1 ? score1 + nums[left] : score1, player1 ? score2 : score2 + nums[left], !player1)
				|| helper(nums, left, right - 1, player1 ? score1 + nums[right] : score1, player1 ? score2 : score2 + nums[right], !player1);
		return helper(nums, left + 1, right, player1 ? score1 + nums[left] : score1, player1 ? score2 : score2 + nums[left], !player1)
				&& helper(nums, left, right - 1, player1 ? score1 + nums[right] : score1, player1 ? score2 : score2 + nums[right], !player1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {0};
		System.out.println(new Solution().PredictTheWinner(nums));
	}

}
