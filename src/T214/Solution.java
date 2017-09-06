package T214;

public class Solution {

	public String shortestPalindrome(String s) {
		int len = s.length();
		int i = len - 1;
		char[] ss = s.toCharArray();
		while (i >= 0 && !isPalindrome(ss, 0, i))
			i --;
		return new StringBuilder(s.substring(i + 1, len)).reverse().toString() + s;
	}
	
	private boolean isPalindrome(char[] s, int start, int end) {
		int left = 0, right = end;
		while (left <= right) {
			if (s[left ++] != s[right --]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().shortestPalindrome("abcd"));
	}

}
