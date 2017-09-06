package T398;

import java.util.Random;

public class Solution {

	private int[] nums;
	private Random random;
	
	public Solution(int[] nums) {
		this.nums = nums;
		random = new Random();
	}
	
	public int pick(int target) {
		int len = nums.length;
		int index = 0, count = 0;
		for (int i = 0; i < len; i ++) {
			if (nums[i] == target) {
				count ++;
				if (random.nextInt(count) % count == 0)
					index = i;
			}
		}
		return index;
	}
}
