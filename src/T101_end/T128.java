package T101_end;

import java.util.HashSet;
import java.util.Set;

public class T128 {

	public int longestConsecutive(int[] nums) {
		if (nums == null) return 0;
		int len = nums.length;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < len; i ++)
			set.add(nums[i]);
		int max = 0;
		for (int ele: set) {
			if (!set.contains(ele - 1)) {
				// find the first element in a consecutive sequence
				int p = ele + 1;
				while (set.contains(p)) 
					p ++;
				if (p - ele > max)
					max = p - ele;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T128 t128 = new T128();
		System.out.println(t128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}

}
