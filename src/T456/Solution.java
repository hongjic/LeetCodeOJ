package T456;

public class Solution {

	
	// O(n^2)
	public boolean find132pattern(int[] nums) {
		// maxmin[i] represents the index of the biggest element after nums[i] and smaller than it.
		int len = nums.length;
		int[] maxmin = new int[len];
		for (int i = 0; i < len; i ++) {
			int max = Integer.MIN_VALUE; 
			maxmin[i] = -1;
			for (int j = i + 1; j < len; j ++) 
				if (nums[j] < nums[i] && nums[j] > max) {
					max = nums[j];
					maxmin[i] = j;
				}
		}
		for (int i = 0; i < len - 2; i ++) 
			for (int j = i + 1; j < len - 1; j ++)
				if (nums[i] < nums[j] && maxmin[j] != -1 && nums[maxmin[j]] > nums[i])
					return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4};
		System.out.println(new Solution().find132pattern(nums));
	}

}
