package T179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i ++)
			arr[i] = String.valueOf(nums[i]);
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i ++)
			sb.append(arr[i]);
		while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {824,938,1399,5607,6973,5703,9609,4398,8247};
		System.out.println(new Solution().largestNumber(nums));
	}

}
