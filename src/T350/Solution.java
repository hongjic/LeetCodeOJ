package T350;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		List<Integer> inter = new ArrayList<Integer>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) i ++;
			else if (nums1[i] > nums2[j]) j ++;
			else {
				inter.add(nums1[i]);
				i ++; j ++;
			}
		}
		int[] result = new int[inter.size()];
		for (int k = 0; k < inter.size(); k ++)
			result[k] = inter.get(k);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = new Solution().intersect(new int[] {1,2,2,1}, new int[]{2,2});
		for (int i = 0; i < result.length; i ++)
			System.out.print(result[i] + " ");
	}

}
