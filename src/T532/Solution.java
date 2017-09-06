package T532;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num: nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		int res = 0;
		for (int num: map.keySet())
			if ((map.containsKey(num + k) && k != 0) || (map.get(num) >= 2 && k == 0))
				res ++;
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1,4,1,5};
		int k = -1;
		System.out.println(new Solution().findPairs(nums, k));
	}

}
