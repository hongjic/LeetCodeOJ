package T188;

public class Solution {

	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (n == 0) return 0;
		if (k > n / 2) return addAllGaps(prices, n);
		int[][] f = new int[n][k + 1];
		for (int t = 1; t <= k; t ++) { // transactions
			int maxPrevious = - prices[0]; //
			for (int i = 1; i < n; i ++) { // f[i][t] from 0..i with t transactions
				// two situations:  sell at prices[i](prices[i] + maxPrevious)   , no sell(f[i - 1][t])
				f[i][t] = Math.max(f[i - 1][t], prices[i] + maxPrevious);
				maxPrevious = Math.max(maxPrevious, f[i - 1][t - 1] - prices[i]);
			}
		}
		return f[n - 1][k];
	}
	
	private int addAllGaps(int[] prices, int n) {
		int sum = 0;
		for (int i = 1; i < n; i ++)
			if (prices[i] > prices[i - 1]) sum += prices[i] - prices[i - 1];
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 3;
		int[] prices = new int[] {1,5,2,4,3,6};
		System.out.println(new Solution().maxProfit(k, prices));
	}

}
