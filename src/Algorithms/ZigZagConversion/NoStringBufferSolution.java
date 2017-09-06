package Algorithms.ZigZagConversion;

public class NoStringBufferSolution {
	
	private static String convert(String s, int numRows) {
		if (numRows == 1) return s;
		char[] list = new char[s.length()];
		int point = 0;
		int index = 0;
		while (index<s.length()) {
			list[point] = s.charAt(index);
			point++;
			index += 2*numRows-2;
		}
		for (int i = 1; i<=numRows-2; i++) {
			int l = i;
			int r = 2*numRows-2-i;
			while (l<s.length() || r<s.length()) {
				if (l<s.length()) {
					list[point] = s.charAt(l);
					point++;
				}
				if (r<s.length()) {
					list[point] = s.charAt(r);
					point++;
				}
				l += 2*numRows-2;
				r += 2*numRows-2;
			}
		}
		index = numRows-1;
		while (index<s.length()) {
			list[point] = s.charAt(index);
			point++;
			index += 2*numRows-2;
		}
		return String.copyValueOf(list);
	}
	
	public static void main(String[] args) {
		String s = "ABCDEFGH";
		System.out.println(convert(s, 9));
	}

}
