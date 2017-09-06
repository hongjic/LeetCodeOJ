package T123;

public class Solution {

	// O(n^2) didn't pass
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 0) return 0;
		int[] one = new int[n];
		int min = prices[0], maxProfit = 0;
		for (int i = 1; i < n; i ++) {
			one[i] = prices[i] - min;
			maxProfit = Math.max(maxProfit, one[i]);
			min = Math.min(min, prices[i]);
		}
		for (int i = 3; i < n; i ++) {
			min = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 2; j --) {
				min = Math.min(min, prices[j]);
				maxProfit = Math.max(maxProfit, prices[i] - min + one[j - 1]);
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[] {1,5,4,3,2,7,8,9,15,7,8,10,5,3,6};
		System.out.println(new Solution().maxProfit(prices));
	}

}
