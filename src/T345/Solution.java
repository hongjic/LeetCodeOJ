package T345;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Solution {
	
	private static Set<Character> vowels;
	
	static {
		vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
	}

	public String reverseVowels(String s) {
		if (s == null || s.length() <= 1) return s;
		char[] list = s.toCharArray();
		int left = 0, right = list.length - 1;
		while (left < right) {
			while (left < right && !vowels.contains(list[left])) left ++;
			if (left == right) break;
			while (left < right && !vowels.contains(list[right])) right --;
			if (left == right) break;
			swap(list, left, right);
			left ++;
			right --;
		}
		return String.valueOf(list);
	}
	
	private void swap(char[] list, int i, int j) {
		char c = list[i];
		list[i] = list[j];
		list[j] = c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().reverseVowels("leetcode"));
	}

}
