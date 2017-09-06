package T309;

public class Solution {

    /*
    `sell` represents the maxprofit before prices[i] that end with sell
    `buy` represents the maxprofit before prices[i] that end with buy
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sell = 0, preSell = 0, buy = Integer.MIN_VALUE, preBuy = 0;
        for (int price: prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);  // use `preSeel` for cooldown time
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }
        return sell;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] f = new int[n];

        for (int i = 1; i < n; i ++) {
            f[i] = f[i - 1];
            for (int j = 0; j < i; j ++) {
                int pre = 0;
                if (j >= 2) pre = f[j - 2];
                f[i] = Math.max(f[i], pre + prices[i] - prices[j]);
            }
        }

        return f[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {6,1,3,2,4,7}));
    }
}
