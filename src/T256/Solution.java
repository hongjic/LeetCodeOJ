package T256;

public class Solution {

	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;
		int n = costs.length;
		int[][] f = new int[n][3];
		f[0] = costs[0];
		for (int i = 1; i < n; i ++) {
			f[i][0] = Math.min(f[i - 1][1], f[i - 1][2]) + costs[i][0];
			f[i][1] = Math.min(f[i - 1][0], f[i - 1][2]) + costs[i][1];
			f[i][2] = Math.min(f[i - 1][0], f[i - 1][1]) + costs[i][2];
		}
		return Math.min(f[n - 1][0], Math.min(f[n - 1][1], f[n - 1][2]));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{3,4,5}, {5,4,3}, {7,2,5}};
		System.out.println(new Solution().minCost(costs));
		
	}

}
