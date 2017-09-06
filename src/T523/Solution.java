package T523;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public boolean checkSubarraySum(int[] nums, int k) {
		// value = int[2]  value[0] = min_index value[1] = max_index
		k = Math.abs(k);
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		int sum = 0, m = 0;
		map.put(0, new int[]{0, 0});
		for (int i = 1; i <= nums.length; i ++ ) {
			sum += nums[i - 1];
			if (k > 0) m = sum % k;
			else m = sum;
			if (!map.containsKey(m))
				map.put(m, new int[]{i, i});
			else {
				map.get(m)[1] = i;
				if (map.get(m)[1] - map.get(m)[0] > 1) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{0, 0};
		int k = 0;
		System.out.println(new Solution().checkSubarraySum(nums, k));
	}

}
