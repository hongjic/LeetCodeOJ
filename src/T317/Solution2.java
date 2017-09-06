package T317;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Solution2 {
	
	private static final int[][] D = {{0, -1}, {-1,0}, {0,1}, {1, 0}};

	public int shortestDistance(int[][] grid) {
		//for every 0, calculate the sum to every buildings.
		int m = grid.length;
		int n = grid[0].length;
		
		Queue<int[]> bfs = new LinkedList<int[]>();
		boolean[][] visited = new boolean[m][n];
		
		// calculate buildings
		int buildings = 0;
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (grid[i][j] == 1) buildings ++;
		
		// for every 0, calculate the sum to all buildings.
		// while most fast answers on leetcode do bfs for every 1, because the number of buildings is much
		// less than the number of empty land in test cases, very tricky.
		int min = Integer.MAX_VALUE;
		for (int row = 0; row < m; row ++)
			for (int col = 0; col < n; col ++)
				if (grid[row][col] == 0) {
					//initialize
					bfs.clear();
					for (int i = 0; i < m; i ++)
						Arrays.fill(visited[i], false);
					bfs.offer(new int[]{row, col, 0});
					int sum = 0, accessible = 0;
					while (!bfs.isEmpty()) {
						int[] p = bfs.poll();
						if (grid[p[0]][p[1]] == 1) { 
							sum += p[2];
							++ accessible;
						}
						if (grid[p[0]][p[1]] == 0)
							for (int i = 0; i < 4; i ++) {
								int x = p[0] + D[i][0];
								int y = p[1] + D[i][1];
								if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 2 && !visited[x][y]) {
									bfs.offer(new int[]{x, y, p[2] + 1});
									visited[x][y] = true;
								}
							}
					}
					if (accessible == buildings && sum < min)
						min = sum;
				}
		
		// if not applicable, -1
		return (min == Integer.MAX_VALUE ? -1 : min);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] grid = {{1,0,2,0,1}, {0,0,0,0,0},{0,0,1,0,0}};
//		int[][] grid = {{1}};
		int[][] grid = {{1,1},{0,1}};
		System.out.println(new Solution().shortestDistance(grid));
	}

}
