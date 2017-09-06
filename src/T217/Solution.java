package T217;

import java.util.Set;
import java.util.HashSet;

public class Solution {

	public boolean containsDuplicate(int[] nums) {
		if (nums == null) return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i ++)
			set.add(nums[i]);
		if (set.size() == nums.length)
			return false;
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().containsDuplicate(new int[] {1,3,5,2,8,9,6}));
	}

}
