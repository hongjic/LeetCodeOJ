package Algorithms.ReverseInteger;

public class Solution {

	private static int reverse(int x) {
		long xx = x;
		if (xx<0) xx = -xx;
		long result = 0;
		while (xx>0) {
			result = result*10+xx%10;
			xx = xx/10;
		}
		if (x>=0 && result<=Integer.MAX_VALUE) return (int)result;
		else if (x<0 && -result>=Integer.MIN_VALUE) return -(int)result;
		else return 0;
	}
	
	public static void main(String[] args) {
		int x = 1534236469;
		System.out.println(reverse(x));
	}

}
