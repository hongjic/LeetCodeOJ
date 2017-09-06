package Algorithms.LongestPalindromicSubstring;

public class Solution {
	
	private static boolean isPalindrome(String s, int left, int length) {
		int right = left+length-1;
		int mid = left+length/2-1;
		for (int i = left; i<=mid; i++) 
			if (s.charAt(i) != s.charAt(right-i+left))
				return false;
		return true;
	}

	private static String longestPalindrome(String s) {
		int len = s.length();
		for (int max = len; max>=1; max--)
			for (int left = 0; left<=len-max; left++) 
				if (isPalindrome(s, left, max)) 
					return s.substring(left, left+max);
		return null;
	}
	
	public static void main(String[] args) {
		String s = "a";
		System.out.println(longestPalindrome(s));
	}

}
