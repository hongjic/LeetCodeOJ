package Algorithms.LongestSubStringWithoutRepeatingCharacters;

public class Solution {

	private static int maxOf(int a, int b) {
		if (a>b) return a;
		return b;
	}
	
	private static boolean noRepeat(String s, int c, int start, int end) {
		for (int i = start; i<=end; i++)
			if (s.charAt(c) == s.charAt(i))
				return false;
		return true;
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int end = 0;
		int max = 0;
		for (int i = 0; i<s.length(); i++) {
			if (i+max-1 >= s.length()-1) break;
			int depth = maxOf(i, end);
			for (depth = depth+1; depth<s.length(); depth++)
				if (!noRepeat(s, depth, i, depth-1)) 
					break;
			end = depth - 1;
			if (end-i+1 > max) 
				max = end-i+1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

}
