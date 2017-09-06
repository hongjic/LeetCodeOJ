package T441;

public class Solution {

	public int arrageCoins(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		int left = 0, right = n; // n = 4
		while (left < right) {
			int mid = (left + right) / 2;
			long coins = (long) mid * (mid + 1) / 2;
			if (n == coins) return mid;
			if (n < coins) right = mid;
			else left = mid + 1;
		}
		return left - 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().arrageCoins(1804289383));
	}

}
