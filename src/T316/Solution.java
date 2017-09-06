package T316;

public class Solution {
	
	public String removeDuplicateLetters(String s) {
		if (s.length() == 0) return s;
		int[] last = new int[26];
		int pos = 0;
		for (int i = s.length() - 1; i >= 0; i -- )
			if (last[s.charAt(i) - 'a'] == 0) last[s.charAt(i) - 'a'] = i;
		for (int i = 0; i < s.length(); i ++) {
			if (s.charAt(i) < s.charAt(pos)) pos = i;
			// the selected letter must be the smallest among 0 to i (the last index of any letter)
			if (last[s.charAt(i) - 'a'] == i) break;
		}
		return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll(String.valueOf(s.charAt(pos)), ""));
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().removeDuplicateLetters("bbac"));
	}
}
