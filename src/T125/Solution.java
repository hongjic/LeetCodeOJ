package T125;

public class Solution {

	private boolean isAlphaNumeric(char c) {
		return isAlpha(c) || isNumeric(c);
	}
	
	private boolean isAlpha(char c) {
		if (c >= 97 && c <= 122) return true;
		if (c >= 65 && c <= 90) return true;
		return false;
	}
	
	private boolean isNumeric(char c) {
		if (c >= 48 && c <= 57) return true;
		return false;
	}
	
	private boolean isEqual(char a, char b) {
		if (a == b) return true;
		if (isAlpha(a) && isAlpha(b) && Math.abs(a - b) == 32)
			return true;
		return false;
	}
	
	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) return true;
		int len = s.length();
		int i = 0, j = len - 1;
		while (i < j) {
			while (i < j && !isAlphaNumeric(s.charAt(i))) i ++;
			while (i < j && !isAlphaNumeric(s.charAt(j))) j --;
			if (i == j) break;
			if (!isEqual(s.charAt(i), s.charAt(j))) return false;
			i ++; j --;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(sol.isPalindrome("0P"));
	}

}
