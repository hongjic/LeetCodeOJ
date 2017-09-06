package T169;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i ++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (map.get(nums[i]) > nums.length / 2) return nums[i];
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().majorityElement(new int[]{1,1,2,3,4,5,6,6,1,1,1,1,1}));
	}

}
