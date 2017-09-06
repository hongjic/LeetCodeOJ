package T122;

public class Solution {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int i = 0, sum = 0, buy = prices[0];
		while (i + 1 < prices.length) {
			while (i + 1 < prices.length && prices[i] == prices[i + 1])
				i ++;
			if (i + 1 == prices.length) break;
			if (prices[i] < prices[i + 1]) {
				buy = prices[i];
				while (i + 1 < prices.length && prices[i] <= prices[i + 1])
					i ++;
				if (i + 1 == prices.length) {
					sum += prices[i] - buy;
					break;
				}
			}
			else {
				sum += prices[i] - buy;
				while (i + 1 < prices.length && prices[i] >= prices[i + 1]) 
					i ++;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] prices = new int[] {1,3,5,4,2,3};
		System.out.println(sol.maxProfit(prices));
	}

}
