package T163;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<String>();
		long left = lower - 1;
		for (int i = 0; i <= nums.length; i ++) {
			long right = (i == nums.length ? upper + 1 : nums[i]); 
			if (right - left == 2)
				result.add(String.valueOf(left + 1));
			else if (right - left > 2)
				result.add(String.valueOf(left + 1) + "->" + String.valueOf(right - 1));
			left = right;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2147483647};
		List<String> result = new Solution().findMissingRanges(nums, 0, 2147483647);
		for (int i = 0; i < result.size(); i ++)
			System.out.println(result.get(i));
	}

}
