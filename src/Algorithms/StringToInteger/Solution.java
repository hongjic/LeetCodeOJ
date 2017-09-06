package Algorithms.StringToInteger;

public class Solution {

	private static int myAtoi(String st) {
		String str = st.trim();
		int positive = 1;
		int i = 0, num = 0, len = str.length();
		if (len < 1) return 0;
		while (i < len) {
			if (str.charAt(i) >='0' && str.charAt(i) <= '9') {
				if (i > 8) {
					long temp = num;
					temp = temp * 10 + str.charAt(i) - 48;
					if (temp > Integer.MAX_VALUE && positive > 0) return Integer.MAX_VALUE;
					else if (temp > -(long)Integer.MIN_VALUE) return Integer.MIN_VALUE;
				}
				num = num * 10 + str.charAt(i) - 48;
				i++;
			}
			else if (str.charAt(i) == '-' && i == 0) {
				positive = -1;
				i++;
			}
			else if (str.charAt(i) == '+' && i == 0 ) {
				i++;
			}
			else i = len;
		}
		return positive * num;
	}
	
	public static void main(String[] args) {
		String str = " -001a242  ";
		System.out.println(myAtoi(str));
	}

}
