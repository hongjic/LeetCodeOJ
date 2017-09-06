package T152;

public class Solution {

	public int maxProduct(int[] nums) {
		if (nums.length == 0) return 0;
		int[] min = new int[nums.length], max = new int[nums.length];
		int res = min[0] = max[0] = nums[0];
		for (int i = 1; i < nums.length; i ++) {
			if (nums[i] == 0) {
				min[i] = 0; max[i] = 0;
			}
			else if (nums[i] > 0) {
				min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
				max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
			}
			else {
				min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
				max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
			}
			if (max[i] > res) res = max[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
