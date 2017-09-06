package T172;

public class Solution {

	public int trailingZeroes(int n) {
		int count5 = 0, count2 = 0;
		long b = 5;
		while (n >= b) {
			count5 += n / b;
			b *= 5;
		}
		b = 2;
		while (n >= b) {
			count2 += n / b;
			
			b *= 2;
		}
		return Math.min(count5, count2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().trailingZeroes(10));
	}

}
