package T121;

public class Solution {

	private int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int min = prices[0];
		int size = prices.length;
		int result = 0;
		for (int i = 1; i < size; i ++) {
			if (prices[i] < min) min = prices[i];
			if (prices[i] - min > result) result = prices[i] - min;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] prices = new int[] {7,6,4,3,1};
		System.out.println(sol.maxProfit(prices));
	}

}
