package T259;

import java.util.Arrays;

public class Solution {

	public int threeSumSmaller(int[] nums, int target) {
		int len = nums.length;
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i < len-2; i ++) {
			int leftSum = target - nums[i];
			int left = i + 1, right = len - 1;
			while (left < right) {
				while (left < right && nums[left] + nums[right] >= leftSum)
					right --;
				if (left == right) break;
				result += right - left;
				left ++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{-2, 0, 1, 3};
		System.out.println(new Solution().threeSumSmaller(nums, 2));
	}

}
