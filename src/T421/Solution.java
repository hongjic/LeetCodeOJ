package T421;

import java.util.Set;
import java.util.HashSet;

public class Solution {

	public int findMaximumXOR(int[] nums) {
		int max = 0, level = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 31; i >= 0; i --) {
			level = level | (1 << i);
			set.clear();
			for (int num: nums)
				set.add(num & level);
			int tmp = max | (1 << i);
			for (int prefix: set)
				if (set.contains(tmp ^ prefix)) {
					max = tmp;
					break;
				}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{3, 10, 5, 25, 2, 8};
		System.out.println(new Solution().findMaximumXOR(nums));
	}

}
