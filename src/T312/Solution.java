package T312;

import java.util.Arrays;

public class Solution {

	private Integer[][] coins;
	private int[] nums;
	
	// nums[-1] = nums[len] = 1;
	public int maxCoins(int[] nums) {
		int len = nums.length;
		coins = new Integer[len][len];
		this.nums = nums;
		for (int i = 0; i < len; i ++)
			Arrays.fill(coins[i], null);
		return findMax(0, len - 1);
	}
	
	private int findMax(int left, int right) {
		if (left > right) return 0;
		if (coins[left][right] != null) return coins[left][right];
		int max = -1;
		for (int last = left; last <= right; last ++) {
			max = Math.max(max, findMax(left, last - 1) + findMax(last + 1, right) + getV(last) * getV(left - 1) * getV(right + 1));
		}
		coins[left][right] = max;
		return max;
	}
	
	private int getV(int index) {
		if (index >= 0 && index <= nums.length - 1) return nums[index];
		return 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().maxCoins(new int[] {8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2}));
	}

}
