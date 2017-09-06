package T123;

public class Solution2 {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
		for (int i = 0; i < n; i ++) {
			sell2 = Math.max(sell2, buy2 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy1 = Math.max(buy1, - prices[i]);
		}
		return sell2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[] {1,2,3,4,5,6,5,4,3,3,2,1};
		System.out.println(new Solution().maxProfit(prices));
	}

}
