package T220;

import java.util.TreeSet;

public class Solution {
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0)
			return false;
		
		final TreeSet<Integer> values = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i ++) {
			final Integer floor = values.floor(nums[i] + t);
			final Integer ceil = values.ceiling(nums[i] - t);
			if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
				return true;
			}
			
			values.add(nums[i]);
			if (i >= k)
				values.remove(nums[i - k]);
		}
		return false;
	}
	
	public static void main (String[] args) {
		System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[] {0,4,8,12,16,9}, 2, 3));
	}

}
