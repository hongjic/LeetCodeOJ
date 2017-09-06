package T487;

public class Solution {

	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0, count0 = 0, max = 0;
		int i = 0, j = 0;
		while (j < nums.length) {
			while (j < nums.length && count0 <= 1) {
				if (nums[j] == 0) count0 ++;
				if (count0 > 1) break;
				count ++;
				j ++;
			}
			if (count > max) max = count;
			if (j == nums.length) break;
			count0 --;
			while (j < nums.length && nums[j] == 0) {
				j ++;
				count0 ++;
				count ++;
			}
			while (count0 > 1) {
				if (nums[i] == 0) count0 --;
				count --;
				i ++;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,0,1,1,0,1,0,1,1,1,1,0,1,1,0,1,0,1};
		System.out.println(new Solution().findMaxConsecutiveOnes(nums));
	}

}
