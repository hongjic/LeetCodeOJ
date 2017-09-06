package T219;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public boolean containsNearByDuplicate(int[] nums, int k) {
		if (nums == null) return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i ++) {
			if (map.containsKey(nums[i])) {
				if (i - map.get(nums[i]) <= k) return true;
				map.put(nums[i], i);
			}
			else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().containsNearByDuplicate(new int[] {0,1,3,6,8,9,3,2,7}, 4));
	}

}
