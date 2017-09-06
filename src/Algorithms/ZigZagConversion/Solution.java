package Algorithms.ZigZagConversion;

public class Solution {

	private static String convert(String s, int numRows) {
		if (numRows == 1) return s;
		StringBuffer sb = new StringBuffer();
		int index = 0;
		while (index<s.length()) {
			sb.append(s.charAt(index));
			index += 2*numRows-2;
		}
		for (int i = 1; i<=numRows-2; i++) {
			int l = i;
			int r = 2*numRows-2-i;
			while (l<s.length() || r<s.length()) {
				if (l<s.length()) sb.append(s.charAt(l));
				if (r<s.length()) sb.append(s.charAt(r));
				l += 2*numRows-2;
				r += 2*numRows-2;
			}
		}
		index = numRows-1;
		while (index<s.length()) {
			sb.append(s.charAt(index));
			index += 2*numRows-2;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "ABCDEFGH";
		System.out.println(convert(s, 9));
	}

}
