package T349;

import java.util.Set;
import java.util.HashSet;

public class Solution {

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i ++)
			set1.add(nums1[i]);
		for (int i = 0; i < nums2.length; i ++)
			set2.add(nums2[i]);
		set1.retainAll(set2);
		int[] result = new int[set1.size()];
		int i = 0;
		for (int ele: set1) {
			result[i] = ele;
			i ++;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = new Solution().intersection(new int[] {1,2,2,1}, new int[] {2,2});
		for (int i = 0; i < result.length; i ++)
			System.out.print(result[i] + " ");
	}

}
