package T342;

public class Solution {

	public boolean isPowerOfFour(int num) {
		if (num <= 0) return false;
		int n = (int) Math.round(Math.sqrt((double) num));
		if (n * n == num && Integer.bitCount(n) == 1) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isPowerOfFour(-3));
	}

}
