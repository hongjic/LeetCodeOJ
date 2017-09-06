package T317;

import java.util.Arrays;

public class Solution {
	
	private static final int[][] D = {{0,-1}, {-1,0}, {0,1}, {1,0}};

	public int shortestDistance(int[][] grid) {
		
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] f = new int[m*n][m*n];
		for (int i = 0; i < m*n; i ++)
			Arrays.fill(f[i], -1);
		
		//initialize f for each point in four directions
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (grid[i][j] != 2) {
					// only check left and above
					for (int d = 0; d < 2; d ++) {
						int ii = i + D[d][0];
						int jj = j + D[d][1];
						if (ii >= 0 && ii < m && jj >= 0 && jj < n && grid[ii][jj] != 2) {
							f[i*n+j][ii*n+jj] = 1;
							f[ii*n+jj][i*n+j] = 1;
						}
					}
				}
		
		// floyd
		for (int k = 0; k <m*n; k ++)
			if (grid[k/n][k%n] == 0)
				for (int i = 0; i < m*n; i ++)
					if (i != k && grid[i/n][i%n] != 2)
						for (int j = i + 1; j < m*n; j ++) // j > i
							if (j !=k && grid[j/n][j%n] != 2 && f[i][k] != -1 && f[k][j] != -1 && (f[i][j] > f[i][k] + f[k][j] || f[i][j] == -1)) {
								f[i][j] = f[i][k] + f[k][j];
								f[j][i] = f[i][k] + f[k][j];
							}
		int min = Integer.MAX_VALUE;
		// find the largest sum
		for (int i = 0; i < m*n; i ++)
			if (grid[i/n][i%n] == 0) {
				int sum = 0;
				boolean flag = true;
				for (int j = 0; j < m*n; j++ ) 
					if (grid[j/n][j%n] == 1) {
						if (f[i][j] == -1) {
							flag = false;
							break;
						}
						sum += f[i][j];
					}
				if (flag && sum < min) 
					min = sum;
			}
		
		return (min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,0,2,0,1}, {0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(new Solution().shortestDistance(grid));
	}

}
