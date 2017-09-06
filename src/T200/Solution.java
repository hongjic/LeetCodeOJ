package T200;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {

	private static final int[][] D = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	
	public int numIslands(char[][] grid) {
		int islands = 0, rows = grid.length;
		if (rows == 0) return 0;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				if (!visited[i][j] && grid[i][j] == '1') {
					islands ++;
					Queue<int[]> q = new LinkedList<int[]>();
					q.offer(new int[]{i, j});
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int[] p = q.poll();
						for (int d = 0; d < 4; d ++) 
							if (p[0] + D[d][0] >= 0 && p[0] + D[d][0] < rows 
							&& p[1] + D[d][1] >= 0 && p[1] + D[d][1] < cols 
							&& !visited[p[0] + D[d][0]][p[1] + D[d][1]]
							&& grid[p[0] + D[d][0]][p[1] + D[d][1]] == '1') {
								q.offer(new int[]{p[0] + D[d][0], p[1] + D[d][1]});
								visited[p[0] + D[d][0]][p[1] + D[d][1]] = true;
							}
					}
				}
		return islands;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid1 = new char[][] {
			"11110".toCharArray(),
			"11010".toCharArray(),
			"11000".toCharArray(),
			"00000".toCharArray()
		};
		char[][] grid2 = new char[][] {
			"11000".toCharArray(),
			"11000".toCharArray(),
			"00100".toCharArray(),
			"00011".toCharArray()
		};
		System.out.println(new Solution().numIslands(grid1));
		System.out.println(new Solution().numIslands(grid2));
	}

}
