package T65;

public class Solution {

	/*
	 * this solution can not pass the test but the hierarchy is clear. 
	 */
	public boolean isNumber(String s) {
		s = s.replaceAll(" ", "");
		if (s.length() == 0) return false;
		if (s.charAt(0) == '-') return isPositiveNumber(s.substring(1));
		else return isPositiveNumber(s);
	}
	
	private boolean isPositiveNumber(String s) {
		int index = s.indexOf("e");
		if (index < 0) return isPositiveFloat(s);
		String s1 = s.substring(0, index), s2 = s.substring(index + 1, s.length());
		return s1.length() > 0 && isPositiveFloat(s1) && s2.length() > 0 && isInteger(s2);
	}
	
	private boolean isPositiveFloat(String s) {
		int index = s.indexOf(".");
		if (index < 0) return isPositiveInteger(s);
		String s1 = s.substring(0, index), s2 = s.substring(index + 1, s.length());
		return s2.length() > 0 && isPositiveInteger(s2) && ((s1.length() > 0 && isPositiveInteger(s1)) || s1.length() == 0);
	}
	
	private boolean isInteger(String s) {
		if (s.charAt(0) == '-') return isPositiveInteger(s.substring(1));
		return isPositiveInteger(s);
	}
	
	private boolean isPositiveInteger(String s) {
		if (s.length() == 0) return false;
		for (char c: s.toCharArray())
			if (!(c >= 48 && c <= 57)) return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isNumber("-"));
	}

}
